package de.longuyen.drawing.operator

import de.longuyen.drawing.core.Chromosome

interface CrossOver {
    fun perform(pair: Pair<Chromosome, Chromosome>, mutator: Mutator, mutationProbability: Float) : Chromosome
}