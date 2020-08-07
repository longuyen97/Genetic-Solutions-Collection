package de.longuyen.poc.shape

import java.util.*

class DynamicRangeProbability(val min: Float, val max: Float): Probability {
    val random = Random()

    override fun next(): Float {
        return min + random.nextFloat() * (max - min)
    }
}