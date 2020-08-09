package de.longuyen.shapespearemonkey

import org.jfree.chart.ChartPanel
import org.knowm.xchart.QuickChart
import org.knowm.xchart.XChartPanel
import org.knowm.xchart.XYChart
import org.knowm.xchart.XYChartBuilder
import java.awt.Color
import java.awt.GridLayout
import javax.swing.*
import javax.swing.border.Border


class GUI : JFrame("Shakespeare's Monkeys Problem") {
    private val bestChromosome: JTextArea = JTextArea()
    private val userInput: JTextArea = JTextArea("""But why, some say, the Moon. Why choose this as our goal. And they may well ask, why climb the highest mountain. Why, thirty five years ago, fly the Atlantic. Why does Rice play Texas. We choose to go to the Moon. We choose to go to the Moon. We choose to go to the Moon in this decade and do the other things, not because they are easy, but because they are hard, because that goal will serve to organize and measure the best of our energies and skills, because that challenge is one that we are willing to accept, one we are unwilling to postpone, and one we intend to win, and the others, too.""")
    private val mainFrameContainer = this.contentPane
    private val generationList = mutableListOf(0.0)
    private val costList = mutableListOf(0.0)
    private val targetList = mutableListOf(0.0)
    private val chart: XYChart
    private val chartPanel: XChartPanel<XYChart>

    init {
        mainFrameContainer.layout = GridLayout(2, 1)
        val border: Border = BorderFactory.createLineBorder(Color.BLACK)
        bestChromosome.border =
            BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))
        userInput.border = BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10))

        bestChromosome.isEditable = false
        bestChromosome.lineWrap = true
        bestChromosome.wrapStyleWord = true
        userInput.lineWrap = true
        userInput.wrapStyleWord = true
        val visualizationPanel = JPanel(GridLayout(1, 2))
        visualizationPanel.add(userInput)
        visualizationPanel.add(bestChromosome)
        mainFrameContainer.add(visualizationPanel)


        targetList[0] = userInput.text.length.toDouble()

        chart = XYChartBuilder().width(400).height(200).title("Population's best fitness").build()
        chart.addSeries("Current best Fitness", generationList, costList)
        chart.addSeries("Best possible Fitness", generationList, targetList)
        chartPanel = XChartPanel(chart)
        mainFrameContainer.add(chartPanel)

        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        this.setSize(1000, 1000)
        this.isVisible = true
    }

    fun run() {
        generationList.clear()
        costList.clear()
        targetList.clear()
        val target = userInput.text
        val pop = Population(target = target, size=1500, mutationRate = 1)
        pop.fitAndSort()
        var generation = 0
        while (pop.chromosomes.first().fitness < target.length) {
            // Core functions
            pop.evolve()
            pop.fitAndSort()

            // Other stuff
            bestChromosome.text = pop.chromosomes.first().geneExpression()

            costList.add(pop.chromosomes.first().fitness.toDouble())
            generationList.add(generation.toDouble())
            targetList.add(target.length.toDouble())
            if(generation % 10 == 0) {
                chart.updateXYSeries("Current best Fitness", generationList, costList, null)
                chart.updateXYSeries("Best possible Fitness", generationList, targetList, null)
                chartPanel.revalidate()
                chartPanel.repaint()
            }
            generation++
        }
    }
}