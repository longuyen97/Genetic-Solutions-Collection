package de.longuyen.knapsack

import java.util.*

fun main() {
    val capacity = 100
    val itemCount = 50
    val profits = IntArray(itemCount)
    val weights = IntArray(itemCount)
    val random = Random()
    for (i in 0 until itemCount) {
        profits[i] = random.nextInt(20)
        weights[i] = random.nextInt(10)
    }

    val pop = Population(
        Context(
            capacity = capacity,
            profits = profits,
            weights = weights,
            mutationProbability = 1,
            populationSize = 20
        )
    )
    pop.fitAndSort()

    var counter = 0
    var oldFitness = 0L
    var generation = 0
    while (counter < 100) {
        pop.evolve()
        pop.fitAndSort()
        println("Generation $generation ${pop.express()}")
        if (oldFitness != pop.chromosomes.first().fitness) {
            oldFitness = pop.chromosomes.first().fitness
            counter = 0
        } else {
            ++counter
        }
        ++generation
    }
}