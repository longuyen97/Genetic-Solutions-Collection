package de.longuyen.poc.select

import de.longuyen.poc.chromosome.IChromosome

interface ISurvivorSelection<T : Comparable<T>> {
    fun <K : IChromosome<T>> select(population: Collection<K>): Collection<Int>

    fun <K : IChromosome<T>> sortOut(population: Collection<K>): Collection<Int>
}