package de.longuyen.travelingsalesman

import java.util.*

class Population(size: Int, graph: CompleteGraph) {
    private var chromosomes = mutableListOf<Chromosome>()

    init {
        for (i in 0 until size) {
            chromosomes.add(Chromosome(graph))
        }
    }

    fun fittest(): Chromosome {
        return chromosomes.first()
    }

    fun worst(): Chromosome {
        return chromosomes.last()
    }

    fun evolve() {
        val newPopulation = mutableListOf<Chromosome>()
        newPopulation.add(chromosomes.first())
        while (newPopulation.size < chromosomes.size) {
            val mother = rouletteSelection()
            val father = rouletteSelection()
            newPopulation.add(mother.mutate().crossover(father.mutate()))
        }
        chromosomes = newPopulation
    }

    fun fitAndSort() {
        chromosomes.parallelStream().forEach {
            it.evaluate()
        }
        chromosomes.sortBy { it.fitness }
    }

    private fun rouletteSelection(): Chromosome {
        val random = Random()
        for (i in chromosomes.indices) {
            val chromosome = chromosomes[i]
            if (i > 0) {
                if (random.nextDouble() <= (chromosomes.size - i) / (chromosomes.size.toDouble() + chromosomes.size * 0.8)) {
                    return chromosome
                }
            }
        }
        return chromosomes.first()
    }
}