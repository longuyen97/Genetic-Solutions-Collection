package de.longuyen.drawing.operator

import de.longuyen.drawing.shape.Shape

interface Mutator {
    fun mutate(gene: Shape, probability: Float): Shape
}