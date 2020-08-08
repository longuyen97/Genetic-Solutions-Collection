package de.longuyen.drawing.operator

import de.longuyen.drawing.Chromosome
import de.longuyen.drawing.shape.Shape

interface Mutator {
    fun mutate(gene: Shape, probability: Float): Shape

    fun mutate(chromosome: Chromosome, probability: Float): Chromosome {
        val mutated = mutableListOf<Shape>()
        chromosome.dna.forEach { gene ->
            mutated.add(mutate(gene, probability))
        }
        return Chromosome(
            mutated.sortedBy { mutated -> mutated.z },
            Double.MAX_VALUE
        )
    }
}