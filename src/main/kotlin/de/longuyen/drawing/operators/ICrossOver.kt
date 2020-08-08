package de.longuyen.drawing.operators

import de.longuyen.drawing.core.Chromosome

interface ICrossOver {
    fun perform(pair: Pair<Chromosome, Chromosome>, mutator: IMutator, mutationProbability: Float) : Chromosome
}