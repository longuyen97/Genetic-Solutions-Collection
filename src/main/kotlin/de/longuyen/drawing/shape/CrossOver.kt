package de.longuyen.drawing.shape

import java.util.*

class CrossOver {
    private val random = Random()

    // probability 1-100
    fun perform(pair: Pair<Chromosome, Chromosome>, mutator: Mutator, mutationProbability: Float) : Chromosome {
        val dnaLength = pair.first.dna.size
        val genes = mutableListOf<Shape>()
        (0 until dnaLength).forEach { i ->
            if (random.nextDouble() > .5) {
                genes.add(mutator.mutate(pair.first.dna[i].copy(), mutationProbability))
            } else {
                genes.add(mutator.mutate(pair.second.dna[i].copy(), mutationProbability))
            }
        }
        return Chromosome(genes, Double.MAX_VALUE)
    }
}