package de.longuyen.drawing.fitness

import de.longuyen.drawing.poc.chromosome.CharChromosome
import java.lang.RuntimeException

class CharFitness(private val target: CharArray) : IFitness<CharChromosome> {
    override fun compute(chromosome: CharChromosome): Double {
        if (chromosome.genes.size != target.size) {
            throw RuntimeException("Gene's size of chromosome ${chromosome.genes.size} is not the same as the target's size ${target.size}.")
        }
        var ret = 0.0
        for (x in target.indices) {
            if (target[x] == chromosome.genes[x]) {
                ret += 1.0
            }
        }
        return ret
    }
}