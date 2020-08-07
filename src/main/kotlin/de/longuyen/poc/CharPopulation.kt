package de.longuyen.poc

import de.longuyen.poc.chromosome.CharChromosome
import de.longuyen.poc.crossover.CharCrossover
import de.longuyen.poc.fitness.CharFitness
import de.longuyen.poc.initializer.CharInitializer
import de.longuyen.poc.mutate.CharMutate
import de.longuyen.poc.select.CharSurvivorSelection
import java.util.*


class CharPopulation(size: Int, private val target: String) {
    private val chromosomes = mutableListOf<CharChromosome>()
    private val fitness = CharFitness(target.toCharArray())

    init {
        val initializer = CharInitializer(target)
        for (i in 0 until size) {
            chromosomes.add(initializer.generate())
        }
    }

    private fun sort() {
        chromosomes.sortWith(Comparator { c1, c2 ->
            fitness.compute(c1).compareTo(fitness.compute(c2))
        })
    }

    fun evolve() {
        val selection = CharSurvivorSelection()
        val crossover = CharCrossover()
        val mutagen = CharMutate()
        sort()

        while (fittest() < target.length) {
            val selected = selection.select(population = chromosomes)
            val sortedOut = selection.sortOut(population = chromosomes)
            val mutated = selection.mutate(population = chromosomes)

            for (i in sortedOut.indices) {
                val crossOver = crossover.mate(chromosomes[selected[0]], chromosomes[selected[1]])
                chromosomes[sortedOut[i]] = crossOver
            }
            for (i in mutated.indices) {
                mutagen.mutate(chromosomes[mutated[i]])
            }
            sort()
            println("Current fittest: ${this.fittest()}")
            println("Target: ${Arrays.toString(target.toCharArray())}")
            println("Best: ${Arrays.toString(chromosomes[0].genes)}")
            println("#########################################################")
        }
    }

    private fun fittest(): Double {
        return fitness.compute(chromosomes[0])
    }
}

fun main() {
    val target = "ich liebe dich"
    val population = CharPopulation(1000, target)
    population.evolve()
}