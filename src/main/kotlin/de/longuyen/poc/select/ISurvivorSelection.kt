package de.longuyen.poc.select

import de.longuyen.poc.chromosome.IChromosome

interface ISurvivorSelection<K: IChromosome> {
    fun select(population: List<K>): List<Int>

    fun sortOut(population: List<K>): List<Int>

    fun mutate(population: List<K>): List<Int>
}