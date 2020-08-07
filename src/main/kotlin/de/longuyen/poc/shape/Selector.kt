package de.longuyen.poc.shape

interface Selector {
    fun select(population: List<Chromosome>): Chromosome
}