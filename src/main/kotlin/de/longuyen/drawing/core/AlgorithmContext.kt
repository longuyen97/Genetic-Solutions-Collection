package de.longuyen.drawing.core

import de.longuyen.drawing.costs.CostFunction
import de.longuyen.drawing.operators.ICrossOver
import de.longuyen.drawing.operators.IProbability
import de.longuyen.drawing.operators.ISelector


data class AlgorithmContext(
    val width: Int,
    val height: Int,
    val geneCount: Int,
    val populationCount: Int,
    val mutationProbability: IProbability,
    val allowedShapes: Array<String>,
    val maxPolygonSize: Int,
    val pixelSize: Int,
    val useAlpha: Boolean,
    val crossOver: ICrossOver,
    val costFunction: CostFunction,
    val selector: ISelector) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AlgorithmContext

        if (width != other.width) return false
        if (height != other.height) return false
        if (geneCount != other.geneCount) return false
        if (populationCount != other.populationCount) return false
        if (mutationProbability != other.mutationProbability) return false
        if (!allowedShapes.contentEquals(other.allowedShapes)) return false
        if (maxPolygonSize != other.maxPolygonSize) return false
        if (pixelSize != other.pixelSize) return false
        if (useAlpha != other.useAlpha) return false
        if (crossOver != other.crossOver) return false
        if (costFunction != other.costFunction) return false
        if (selector != other.selector) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        result = 31 * result + geneCount
        result = 31 * result + populationCount
        result = 31 * result + mutationProbability.hashCode()
        result = 31 * result + allowedShapes.contentHashCode()
        result = 31 * result + maxPolygonSize
        result = 31 * result + pixelSize
        result = 31 * result + useAlpha.hashCode()
        result = 31 * result + crossOver.hashCode()
        result = 31 * result + costFunction.hashCode()
        result = 31 * result + selector.hashCode()
        return result
    }
}