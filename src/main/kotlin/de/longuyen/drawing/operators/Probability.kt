package de.longuyen.drawing.operators

import java.util.*

class Probability(private val min: Float, private val max: Float): IProbability {
    private val random = Random()

    override fun next(): Float {
        return min + random.nextFloat() * (max - min)
    }
}