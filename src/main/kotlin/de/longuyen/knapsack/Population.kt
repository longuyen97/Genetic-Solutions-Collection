package de.longuyen.knapsack

import java.lang.StringBuilder
import java.util.*
import java.util.stream.IntStream

class Population(private val context: Context) {
    var chromosomes: Array<Chromosome> = Array(context.populationSize) { Chromosome(context) }
    private val random = Random()

    fun fitAndSort() {
        IntStream.range(0, chromosomes.size).parallel().forEach {
            chromosomes[it].fit()
        }
        chromosomes.sortByDescending(Chromosome::fitness)
    }

    fun express() : String{
        val ret = StringBuilder()
        ret.append("Fitness ${chromosomes.first().fitness} - Weights ${chromosomes.first().weights}")
        return ret.toString()
    }

    fun evolve() {
        val newPopulation = mutableListOf<Chromosome>()
        newPopulation.add(chromosomes.first())
        while (newPopulation.size < chromosomes.size) {
            val mother = select()
            val father = select()
            newPopulation.add(mother.mutate().crossover(father.mutate()))
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