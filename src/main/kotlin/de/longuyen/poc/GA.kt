package de.longuyen.poc

import java.util.*

class GA {
    private val population: Population = Population()

    fun crossover() {
        val rn = Random()
        //Select a random crossover point
        val crossOverPoint = rn.nextInt(population.chromosomes[0]!!.genes.size)
        //Swap values among parents
        for (i in 0 until crossOverPoint) {
            val temp = population.fittest().genes[i]
            population.fittest().genes[i] = population.secondFittest().genes[i]
            population.secondFittest().genes[i] = temp
        }
    }

    fun mutation(){

    }
}