package de.longuyen.drawing.operator

import de.longuyen.drawing.operator.Probability
import java.util.*

class DynamicRangeProbability(val min: Float, val max: Float):
    Probability {
    val random = Random()

    override fun next(): Float {
        return min + random.nextFloat() * (max - min)
    }
}