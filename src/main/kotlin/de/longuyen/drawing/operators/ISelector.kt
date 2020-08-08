package de.longuyen.drawing.operators

import de.longuyen.drawing.core.Chromosome

interface ISelector {
    fun select(population: List<Chromosome>): Chromosome
}