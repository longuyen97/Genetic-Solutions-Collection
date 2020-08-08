package de.longuyen.drawing.operator

class StaticProbability(private val probability: Float): Probability {
    override fun next(): Float {
        return probability
    }
}