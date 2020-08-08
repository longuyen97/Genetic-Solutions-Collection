package de.longuyen.drawing.shape

class StaticProbability(private val probability: Float): Probability {
    override fun next(): Float {
        return probability
    }
}