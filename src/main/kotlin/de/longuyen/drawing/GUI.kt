package de.longuyen.drawing


import de.longuyen.drawing.core.AlgorithmContext
import de.longuyen.drawing.core.Chromosome
import de.longuyen.drawing.core.PopulationBuilder
import de.longuyen.drawing.costs.ImageDifference
import de.longuyen.drawing.operators.CrossOver
import de.longuyen.drawing.operators.Probability
import de.longuyen.drawing.operators.Mutator
import de.longuyen.drawing.operators.Selector
import de.longuyen.drawing.shapes.*
import org.knowm.xchart.QuickChart
import org.knowm.xchart.XChartPanel
import org.knowm.xchart.XYChart
import java.awt.Graphics
import java.awt.GridLayout
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

class GUI(filename: String) {
    private val target: BufferedImage = ImageIO.read(File(filename))
    val context = AlgorithmContext(
        width = target.width,
        height = target.height,
        pixelSize = 8,
        geneCount = 1000,
        populationCount = 15,
        mutationProbability = Probability(0.001f, 0.01f),
        allowedShapes = arrayOf(
            Circle::class.java.simpleName,
            Ellipse::class.java.simpleName
        ),
        maxPolygonSize = 3,
        useAlpha = true,
        crossOver = CrossOver(),
        costFunction = ImageDifference(target, 4),
        selector = Selector()
    )

    private val mutator = Mutator(context)
    val populationBuilder = PopulationBuilder(context)

    private val decodedImage: JPanel
    private val targetImage: JPanel
    private val imagesPanel: JPanel
    private val chart: XYChart
    private val chartPanel : XChartPanel<XYChart>
    val mostFitCanvas: BufferedImage = BufferedImage(context.width, context.height, BufferedImage.TYPE_INT_ARGB)
    val mostFitCanvasGraphics: Graphics = mostFitCanvas.graphics
    var population = populationBuilder.newPopulation()
    val saveOutputFrequency = 20
    var currentGeneration = 0
    private val generationList = mutableListOf(0.0)
    private val costList = mutableListOf(0.0)

    init {
        val frame = JFrame("Population based genetic approximation")
        val mainFrameContainer = frame.contentPane
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.setSize(target.width * 2, target.height * 2)
        frame.isVisible = true
        mainFrameContainer.layout = GridLayout(2, 2)

        decodedImage = object : JPanel() {
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                populationBuilder.expressDna(mostFitCanvasGraphics, population.first())
                g.drawImage(mostFitCanvas, 0, 0, context.width, context.height, this)

                if (currentGeneration % saveOutputFrequency == 0) {
                    ImageIO.write(mostFitCanvas, "png", File("target/evolved_$currentGeneration.png"))
                }
            }
        }

        targetImage = object : JPanel(){
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                g.drawImage(target, 0, 0, this)
            }
        }

        imagesPanel = JPanel(GridLayout(1, 2))
        imagesPanel.add(targetImage)
        imagesPanel.add(decodedImage)

        decodedImage.setSize(target.width, target.height)
        mainFrameContainer.add(imagesPanel)

        chart = QuickChart.getChart("Population's best fitness", "Epochs", "Cost", "cost", generationList, costList)
        chartPanel = XChartPanel(chart)
        mainFrameContainer.add(chartPanel)
        decodedImage.revalidate()
        imagesPanel.revalidate()
        frame.revalidate()
    }

    fun run() {
        generationList.removeAt(0)
        costList.removeAt(0)
        do {
            population = evaluateFitness(population)
            generationList.add(currentGeneration.toDouble())
            costList.add(population.first().fitness)
            if(currentGeneration % 10 == 0) {
                chart.updateXYSeries("cost", generationList, costList, null)
            }
            chartPanel.revalidate()
            chartPanel.repaint()
            targetImage.revalidate()
            decodedImage.revalidate()
            decodedImage.repaint()
            imagesPanel.revalidate()
            population = buildNextGeneration(population)
            currentGeneration++
        } while (population.first().fitness > 0)
        ImageIO.write(mostFitCanvas, "png", File("target/evolved.png"))
    }


    private fun buildNextGeneration(population: List<Chromosome>): List<Chromosome> {
        val nextGeneration = mutableListOf<Chromosome>()
        // elitism
        nextGeneration.add(population.first())

        while (nextGeneration.size < population.size) {
            val one = context.selector.select(population)
            val two = context.selector.select(population)
            nextGeneration.add(context.crossOver.perform(Pair(one, two), mutator, context.mutationProbability.next()))
        }

        return nextGeneration
    }

    private fun evaluateFitness(population: List<Chromosome>): List<Chromosome> {
        population.parallelStream().forEach() { chromosome ->
            val canvas = BufferedImage(context.width, context.height, BufferedImage.TYPE_INT_ARGB)
            val canvasGraphics: Graphics = canvas.graphics
            populationBuilder.expressDna(canvasGraphics, chromosome)
            chromosome.fitness = context.costFunction.compare(canvas)
        }
        return population.sortedBy { individual -> individual.fitness }
    }
}