package de.longuyen.drawing


import de.longuyen.drawing.costs.ImageDifference
import de.longuyen.drawing.operator.CrossOver
import de.longuyen.drawing.operator.DynamicRangeProbability
import de.longuyen.drawing.operator.IncrementalMutator
import de.longuyen.drawing.operator.StochasticSelector
import de.longuyen.drawing.shape.*
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

class PopulationBasedGeneticDraw(filename: String) {
    private val target: BufferedImage = ImageIO.read(File(filename))
    val context = PopulationContext(
        width = target.width,
        height = target.height,
        geneCount = 1000,
        populationCount = 15,
        mutationProbability = DynamicRangeProbability(0.001f, 0.01f),
        allowedShapes = arrayOf(
            ShapeType.CIRCLE,
            ShapeType.ELLIPSE
        ),
        maxPolygonSize = 3,
        useAlpha = true
    )

    private val mutator = IncrementalMutator(context)
    val genetic = Genetic(context)
    private val crossOver = CrossOver()
    private val fitnessFunction = ImageDifference(target, 4)
    private val selector = StochasticSelector()

    private val decodedImage: JPanel
    private val targetImage: JPanel
    private val imagesPanel: JPanel
    private val chart: XYChart
    private val chartPanel : XChartPanel<XYChart>
    val mostFitCanvas: BufferedImage = BufferedImage(context.width, context.height, BufferedImage.TYPE_INT_ARGB)
    val mostFitCanvasGraphics: Graphics = mostFitCanvas.graphics
    var population = genetic.newPopulation()
    val saveOutput = true
    val saveOutputFrequency = 20
    var i = 0
    private val epochs = mutableListOf(0.0)
    private val differences = mutableListOf(0.0)

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

        chart = QuickChart.getChart("Population's best fitness", "Epochs", "Cost", "cost", epochs, differences)
        chartPanel = XChartPanel(chart)
        mainFrameContainer.add(chartPanel)
        decodedImage.revalidate()
        imagesPanel.revalidate()
        frame.revalidate()
    }

    fun run() {
        epochs.removeAt(0)
        differences.removeAt(0)
        do {
            population = evaluateFitness(population)
            epochs.add(i.toDouble())
            differences.add(population.first().fitness)
            if(i % 10 == 0) {
                chart.updateXYSeries("cost", epochs, differences, null)
            }
            chartPanel.revalidate()
            chartPanel.repaint()
            targetImage.revalidate()
            decodedImage.revalidate()
            decodedImage.repaint()
            imagesPanel.revalidate()
            population = buildNextGeneration(population)
            i++
        } while (population.first().fitness > 0)
        ImageIO.write(mostFitCanvas, "png", File("target/evolved.png"))
    }


    private fun buildNextGeneration(population: List<Chromosome>): List<Chromosome> {
        val nextGeneration = mutableListOf<Chromosome>()
        // elitism
        nextGeneration.add(population.first())

        while (nextGeneration.size < population.size) {
            val one = selector.select(population)
            val two = selector.select(population)
            nextGeneration.add(crossOver.perform(Pair(one, two), mutator, context.mutationProbability.next()))
        }

        return nextGeneration
    }

    private fun evaluateFitness(population: List<Chromosome>): List<Chromosome> {
        population.parallelStream().forEach() { chromosome ->
            val canvas = BufferedImage(context.width, context.height, BufferedImage.TYPE_INT_ARGB)
            val canvasGraphics: Graphics = canvas.graphics
            genetic.expressDna(canvasGraphics, chromosome)
            chromosome.fitness = fitnessFunction.compare(canvas)
        }
        return population.sortedBy { individual -> individual.fitness }
    }
}