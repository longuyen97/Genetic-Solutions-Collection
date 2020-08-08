package de.longuyen.drawing.operators

import de.longuyen.drawing.shapes.Shape

interface IMutator {
    fun mutate(gene: Shape, probability: Float): Shape
}