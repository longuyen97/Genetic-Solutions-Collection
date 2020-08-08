package de.longuyen.drawing

import de.longuyen.drawing.shape.Shape

data class Chromosome(val dna: List<Shape>, var fitness: Double)