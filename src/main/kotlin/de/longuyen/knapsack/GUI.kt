package de.longuyen.knapsack

import org.knowm.xchart.XChartPanel
import org.knowm.xchart.XYChart
import org.knowm.xchart.XYChartBuilder
import javax.swing.*


class GUI(private val context: Context) : JFrame("Knapsack Problem") {
    private val mainFrameContainer = this.contentPane
    private val generationList = mutableListOf(0.0)
    private val fitness = mutableListOf(0.0)
    private val weightsList = mutableListOf(0.0)
    private val maxWeightList = mutableListOf(0.0)
    private val chart: XYChart = XYChartBuilder().width(400).height(200).title("Best solution to the knapsack problem with 2^${context.itemCount} possible combinations").build()
    private val chartPanel: XChartPanel<XYChart>

    init {
        chart.addSeries("Sack's current profit", generationList, fitness)
        chart.addSeries("Sack's current weight", generationList, weightsList)
        chart.addSeries("Sack's maximal capacity", generationList, maxWeightList)
        chartPanel = XChartPanel(chart)
        mainFrameContainer.add(chartPanel)

        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        this.setSize(1000, 1000)
        this.isVisible = true
    }

    fun run() {
        generationList.clear()
        fitness.clear()
        maxWeightList.clear()
        weightsList.clear()

        val pop = Population(context = context)
        pop.fitAndSort()
        var generation = 0
        while (true) {
            pop.evolve()
            pop.fitAndSort()
            ++generation

            fitness.add(pop.chromosomes.first().fitness.toDouble())
            weightsList.add(pop.chromosomes.first().weights.toDouble())
            maxWeightList.add(context.capacity.toDouble())
            generationList.add(generation.toDouble())
            if(generation % 100 == 0) {
                chart.updateXYSeries("Sack's current profit", generationList, fitness, null)
                chart.updateXYSeries("Sack's current weight", generationList, weightsList, null)
                chart.updateXYSeries("Sack's maximal capacity", generationList, maxWeightList, null)
                chartPanel.revalidate()
                chartPanel.repaint()
            }
        }
    }
}