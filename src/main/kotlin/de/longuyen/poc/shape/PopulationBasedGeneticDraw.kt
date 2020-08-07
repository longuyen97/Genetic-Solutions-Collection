package de.longuyen.poc.shape


import ImageDifference
import org.knowm.xchart.QuickChart
import org.knowm.xchart.XChartPanel
import org.knowm.xchart.XYChart
import java.awt.Graphics
import java.awt.GridLayout
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants


fun main() {
    PopulationBasedGeneticDraw().run()
}

class PopulationBasedGeneticDraw {
    val random = Random()
    private val target: BufferedImage = ImageIO.read(File("images/naruto.jpg"))
    val context = PopulationContext(
        width = target.width,
        height = target.height,
        geneCount = 2500,
        populationCount = 20,
        mutationProbability = DynamicRangeProbability(0.001f, 0.01f),
        allowedShapes = arrayOf(ShapeType.RECTANGLE, ShapeType.ELLIPSE),
        maxPolygonSize = 3,
        useAlpha = true
    )

    private val mutator = IncrementalMutator(context)
    val genetic = Genetic(context)
    private val crossOver = CrossOver()
    private val fitnessFunction = ImageDifference(2)
    private val selector = StochasticSelector()

    private val canvas: BufferedImage = BufferedImage(context.width, context.height, BufferedImage.TYPE_INT_ARGB)
    private val canvasGraphics: Graphics = canvas.graphics
    private val decodedImage: JPanel
    private val targetImage: JPanel
    private val imagesPanel: JPanel
    private val chart: XYChart
    private val chartPanel : XChartPanel<XYChart>
    val mostFitCanvas: BufferedImage = BufferedImage(context.width, context.height, BufferedImage.TYPE_INT_ARGB)
    val mostFitCanvasGraphics: Graphics = mostFitCanvas.graphics
    var population = genetic.newPopulation()
    val saveOutput = true
    val saveOutputFrequency = 25
    var i = 0
    private val epochs = mutableListOf<Double>(0.0)
    private val differences = mutableListOf<Double>(0.0)

    init {
        val frame = JFrame()
        val mainFrameContainer = frame.contentPane
        frame.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        frame.setSize(target.width * 2, target.height * 2)
        frame.isVisible = true
        mainFrameContainer.layout = GridLayout(2, 2)

        decodedImage = object : JPanel() {
            override fun paintComponent(g: Graphics) {
                super.paintComponent(g)
                genetic.expressDna(mostFitCanvasGraphics, population.first())
                g.drawImage(mostFitCanvas, 0, 0, context.width, context.height, this)

                if (saveOutput && (i % saveOutputFrequency == 0)) {
                    ImageIO.write(mostFitCanvas, "png", File("target/evolved_$i.png"))
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

        chart = QuickChart.getChart("Model's performance", "Epochs", "Cost", "cost", epochs, differences)
        chartPanel = XChartPanel(chart)
        mainFrameContainer.add(chartPanel)
        decodedImage.revalidate()
        frame.revalidate()
    }

    fun run() {
        do {
            population = evaluateFitness(canvasGraphics, population)
            epochs.add(i.toDouble())
            differences.add(population.first().fitness)
            if (epochs.size > 100) {
                epochs.removeAt(0)
            }
            if (differences.size > 100) {
                differences.removeAt(0)
            }
            chart.updateXYSeries("cost", epochs, differences, null)
            chartPanel.revalidate()
            chartPanel.repaint()
            println("${i}, ${population.first().fitness}")
            population = buildNextGeneration(population)
            i++
        } while (population.first().fitness > 0)
        ImageIO.write(mostFitCanvas, "png", File("target/evolved.png"))
    }


    private fun buildNextGeneration(population: List<Chromosome>): List<Chromosome> {
        val nextGeneration = mutableListOf<Chromosome>()

        if (context.populationCount == 1) {
            throw RuntimeException("Population must be > 1")
        }
        // elitism
        nextGeneration.add(population.first())

        while (nextGeneration.size < population.size) {
            val one = selector.select(population)
            val two = selector.select(population)
            nextGeneration.add(crossOver.perform(Pair(one, two), mutator, context.mutationProbability.next()))
        }

        return nextGeneration
    }

    private fun evaluateFitness(g: Graphics, population: List<Chromosome>): List<Chromosome> {
        population.forEach { individual ->
            genetic.expressDna(g, individual) // expresses to canvas, reuse
            individual.fitness = fitnessFunction.compare(canvas, target)
        }
        return population.sortedBy { individual -> individual.fitness }
    }
}