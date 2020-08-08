package de.longuyen.drawing.operator

import de.longuyen.drawing.Chromosome

interface Selector {
    fun select(population: List<Chromosome>): Chromosome
}