package de.longuyen.drawing.shape

interface Selector {
    fun select(population: List<Chromosome>): Chromosome
}