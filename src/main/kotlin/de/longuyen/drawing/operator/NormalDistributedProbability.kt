package de.longuyen.drawing.operator

import java.util.*


class NormalDistributedProbability(private val mean: Float, private val variance: Float) : Probability{
    private val random = Random()

    override fun next(): Float {
        return (random.nextGaussian() * variance + mean).toFloat()
    }

}