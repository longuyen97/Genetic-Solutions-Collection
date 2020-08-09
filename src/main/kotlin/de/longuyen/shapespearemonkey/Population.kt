package de.longuyen.shapespearemonkey

import java.lang.IllegalArgumentException
import java.util.*
import java.util.stream.IntStream

class Population(private val target: String, size: Int = 100, private val mutationRate: Int = 1) {
    var chromosomes: Array<Chromosome> = Array(size) { Chromosome(target.length) }
    private val random = Random()

    init {
        for (i in target.indices) {
            if (!ALPHABET.toHashSet().contains(target[i])) {
                throw IllegalArgumentException("The character ${target[i]} is not in the alphabet and therefore can not be reconstructed")
            }
        }
    }

    fun fitAndSort() {
        IntStream.range(0, chromosomes.size).parallel().forEach {
            chromosomes[it].fit(target)
        }
        chromosomes.sortByDescending(Chromosome::fitness)
    }

    fun evolve() {
        val newPopulation = mutableListOf<Chromosome>()
        newPopulation.add(chromosomes.first())
        while (newPopulation.size < chromosomes.size) {
            val mother = select()
            val father = select()
            newPopulation.add(mother.mutate(mutationRate).crossover(father.mutate(mutationRate)))
        }
        chromosomes = newPopulation.toTypedArray()
    }

    private fun select(): Chromosome {
        for (i in chromosomes.indices) {
            val chromosome = chromosomes[i]
            if (i > 0) {
                if (random.nextDouble() <= (chromosomes.size - i) / (chromosomes.size.toDouble() + chromosomes.size * 0.6)) {
                    return chromosome
                }
            }
        }
        return chromosomes.first()
    }
}