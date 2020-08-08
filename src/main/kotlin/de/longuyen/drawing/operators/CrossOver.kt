package de.longuyen.drawing.operators

import de.longuyen.drawing.core.Chromosome
import de.longuyen.drawing.shapes.Shape
import java.util.*

class CrossOver : ICrossOver{
    private val random = Random()

    /**
     * Mating two chromosomes to produce a new one
     */
    override fun perform(pair: Pair<Chromosome, Chromosome>, mutator: IMutator, mutationProbability: Float) : Chromosome {
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