package de.longuyen.drawing.select

import de.longuyen.drawing.poc.chromosome.IChromosome

interface ISurvivorSelection<K: IChromosome> {
    fun select(population: List<K>): List<Int>

    fun sortOut(population: List<K>): List<Int>

    fun mutate(population: List<K>): List<Int>
}