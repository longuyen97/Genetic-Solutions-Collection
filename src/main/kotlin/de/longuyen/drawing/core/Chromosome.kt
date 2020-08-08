package de.longuyen.drawing.core

import de.longuyen.drawing.shapes.Shape

data class Chromosome(val dna: List<Shape>, var fitness: Double)