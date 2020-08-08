package de.longuyen.drawing.operator

import java.util.*

class UniformProbability(private val min: Float, private val max: Float): Probability {
    private val random = Random()

    override fun next(): Float {
        return min + random.nextFloat() * (max - min)
    }
}