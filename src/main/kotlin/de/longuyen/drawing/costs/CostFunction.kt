package de.longuyen.drawing.costs

import java.awt.image.BufferedImage

interface CostFunction {
    fun compare(bi2: BufferedImage): Double
}