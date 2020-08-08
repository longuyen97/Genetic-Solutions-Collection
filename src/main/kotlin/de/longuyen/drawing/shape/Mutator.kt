package de.longuyen.drawing.shape

interface Mutator {
    fun mutate(gene: Shape, probability: Float): Shape

    fun mutate(chromosome: Chromosome, probability: Float): Chromosome {
        val mutated = mutableListOf<Shape>()
        chromosome.dna.forEach { gene ->
            mutated.add(mutate(gene, probability))
        }
        return Chromosome(mutated.sortedBy { mutated -> mutated.z }, Double.MAX_VALUE)
    }
}