package de.longuyen.drawing

import de.longuyen.drawing.operator.Probability
import de.longuyen.drawing.shape.ShapeType
import de.longuyen.drawing.operator.StaticProbability


data class PopulationContext(val width: Int,
                             val height: Int,
                             val geneCount: Int = 128,
                             val populationCount: Int = 20,
                             val mutationProbability: Probability = StaticProbability(
                                 0.01f
                             ),
                             val allowedShapes: Array<ShapeType> = arrayOf(
                                 ShapeType.ELLIPSE,
                                 ShapeType.RECTANGLE
                             ),
                             val maxPolygonSize: Int = 5,
                             val pixelSize: Int = 8,
                             val useAlpha: Boolean = true) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PopulationContext

        if (width != other.width) return false
        if (height != other.height) return false
        if (geneCount != other.geneCount) return false
        if (populationCount != other.populationCount) return false
        if (mutationProbability != other.mutationProbability) return false
        if (!allowedShapes.contentEquals(other.allowedShapes)) return false
        if (maxPolygonSize != other.maxPolygonSize) return false
        if (pixelSize != other.pixelSize) return false
        if (useAlpha != other.useAlpha) return false

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
        return result
    }
}