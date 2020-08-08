package de.longuyen.drawing.chromosome

import java.util.*

data class CharChromosome(var genes : CharArray) : IChromosome {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CharChromosome

        return Arrays.equals(genes, other.genes)
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(genes)
    }

    override fun toString(): String {
        return "Chromosome(genes=${genes.contentToString()})"
    }
}