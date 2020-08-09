package de.longuyen.knapsack

import java.util.*

fun main() {
    val capacity = 500
    val itemCount = 500
    val profits = IntArray(itemCount)
    val weights = IntArray(itemCount)
    val random = Random()
    for (i in 0 until itemCount) {
        profits[i] = random.nextInt(15) + 1
        weights[i] = random.nextInt(15) + 1
    }

    val context =Context(
            capacity = capacity,
            profits = profits,
            weights = weights,
            mutationProbability = 3,
            populationSize = 1000
        )
    GUI(context).run()
}