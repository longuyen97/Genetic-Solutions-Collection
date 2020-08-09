package de.longuyen.knapsack

import java.lang.IllegalArgumentException

data class Context(
    val capacity : Int = 9,
    val profits : IntArray = intArrayOf(6, 5, 8, 9, 6, 7, 3),
    val weights : IntArray = intArrayOf(2, 3, 6, 7, 5, 9, 4),
    val mutationProbability: Int = 1,
    val populationSize: Int = 10
) {
    val itemCount: Int

    init {
        if(profits.size != weights.size){
            throw IllegalArgumentException("Usefulness and weights don't have the same size")
        }
        itemCount = profits.size
    }

    override fun toString(): String {
        return """
            Knapsack Problem:
            Maximal capacity: $capacity
            Item count: $itemCount
        """.trimIndent()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Context

        if (capacity != other.capacity) return false
        if (!profits.contentEquals(other.profits)) return false
        if (!weights.contentEquals(other.weights)) return false
        if (mutationProbability != other.mutationProbability) return false
        if (populationSize != other.populationSize) return false

        return true
    }

    override fun hashCode(): Int {
        var result = capacity
        result = 31 * result + profits.contentHashCode()
        result = 31 * result + weights.contentHashCode()
        result = 31 * result + mutationProbability
        result = 31 * result + populationSize
        return result
    }
}