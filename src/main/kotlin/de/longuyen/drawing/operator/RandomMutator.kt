package de.longuyen.drawing.operator

import de.longuyen.drawing.core.PopulationBuilder
import de.longuyen.drawing.core.AlgorithmContext
import de.longuyen.drawing.shape.*
import java.lang.IllegalArgumentException
import java.util.*

class RandomMutator(private val algorithmContext: AlgorithmContext) : Mutator {
    private val random = Random()
    private val genetic = PopulationBuilder(algorithmContext)

    // for moving/size
    private val maxDelta = ((algorithmContext.width + algorithmContext.height) / 2) / 2
    private val halfDelta = maxDelta / 2 + 2

    // for color
    private val maxColorDelta = 100
    private val halfMaxColorDelta = maxColorDelta / 2

    // for moving/size pixels
    private val maxPixelWidth = algorithmContext.width / algorithmContext.pixelSize
    private val maxPixelHeight = algorithmContext.height / algorithmContext.pixelSize

    override fun mutate(gene: Shape, probability: Float): Shape {
        if (random.nextDouble() > probability) { return gene }
        val name = gene.javaClass.simpleName
        when (name) {
            Rectangle::class.java.simpleName -> return mutateRectangle(gene as Rectangle)
            Ellipse::class.java.simpleName -> return mutateEllipse(gene as Ellipse)
            Polygon::class.java.simpleName -> return mutatePolygon(gene as Polygon)
            Pixel::class.java.simpleName -> return mutatePixel(gene as Pixel)
            Circle::class.java.simpleName -> return mutateCircle(gene as Circle)
        }
        throw IllegalArgumentException("Shape is not allowed: $name")
    }

    private fun mutatePixel(gene: Pixel): Pixel {
        when (random.nextInt(7)) {
            0 -> gene.x = genetic.bound((gene.x / algorithmContext.pixelSize) + random.nextInt(maxPixelWidth / 2) - maxPixelWidth / 4 , 0, maxPixelWidth) * algorithmContext.pixelSize
            1 -> gene.y = genetic.bound((gene.y / algorithmContext.pixelSize) + random.nextInt(maxPixelHeight / 2) - maxPixelHeight / 4, 0, maxPixelHeight) * algorithmContext.pixelSize
            2 -> gene.z = random.nextInt(1000)
            3 -> mutateColor(gene, 0) // red
            4 -> mutateColor(gene, 1) // green
            5 -> mutateColor(gene, 2) // blue
            6 -> mutateColor(gene, 3) // alpha
        }
        return gene
    }

    private fun mutatePolygon(gene: Polygon): Polygon {
        if (random.nextBoolean()) {
            when (random.nextInt(4)) {
                0 -> mutateColor(gene, 0) // red
                1 -> mutateColor(gene, 1) // green
                2 -> mutateColor(gene, 2) // blue
                3 -> mutateColor(gene, 3) // alpha
            }
        }
        else { // mutate position
            if (random.nextBoolean()) {
                val position = random.nextInt(gene.x.size)
                gene.x[position] = genetic.bound(gene.x[position] + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.width)
                gene.y[position] = genetic.bound(gene.y[position] + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.height)
            } else {
                gene.z = random.nextInt(1000)
            }
        }
        return gene
    }

    private fun mutateRectangle(gene: Rectangle): Rectangle {
        when (random.nextInt(9)) {
            0 -> gene.x = genetic.bound(gene.x + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.width - gene.w)
            1 -> gene.y = genetic.bound(gene.y + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.height - gene.h)
            2 -> gene.z = random.nextInt(1000)
            3 -> gene.w = genetic.bound(gene.w + random.nextInt(maxDelta) - halfDelta, 5, algorithmContext.width)
            4 -> gene.h = genetic.bound(gene.h + random.nextInt(maxDelta) - halfDelta, 5, algorithmContext.height)
            5 -> mutateColor(gene, 0) // red
            6 -> mutateColor(gene, 1) // green
            7 -> mutateColor(gene, 2) // blue
            8 -> mutateColor(gene, 3) // alpha
        }
        return gene
    }

    private fun mutateEllipse(gene: Ellipse): Ellipse {
        when (random.nextInt(9)) {
            0 -> gene.x = genetic.bound(gene.x + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.width - gene.w)
            1 -> gene.y = genetic.bound(gene.y + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.height - gene.h)
            2 -> gene.z = random.nextInt(1000)
            3 -> gene.w = genetic.bound(gene.w + random.nextInt(maxDelta) - halfDelta, 5, algorithmContext.width)
            4 -> gene.h = genetic.bound(gene.h + random.nextInt(maxDelta) - halfDelta, 5, algorithmContext.height)
            5 -> mutateColor(gene, 0) // red
            6 -> mutateColor(gene, 1) // green
            7 -> mutateColor(gene, 2) // blue
            8 -> mutateColor(gene, 3) // alpha
        }
        return gene
    }

    private fun mutateCircle(gene: Circle): Circle {
        when (random.nextInt(8)) {
            0 -> gene.x = genetic.bound(gene.x + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.width - gene.r)
            1 -> gene.y = genetic.bound(gene.y + random.nextInt(maxDelta) - halfDelta, 0, algorithmContext.height - gene.r)
            2 -> gene.z = random.nextInt(1000)
            3 -> gene.r = genetic.bound(gene.r + random.nextInt(maxDelta) - halfDelta, 5, algorithmContext.width)
            4 -> mutateColor(gene, 0) // red
            5 -> mutateColor(gene, 1) // green
            6 -> mutateColor(gene, 2) // blue
            7 -> mutateColor(gene, 3) // alpha
        }
        return gene
    }

    private fun mutateColor(gene: Shape, i: Int) {
        gene.color[i] = genetic.bound(gene.color[i] + random.nextInt(maxColorDelta) - halfMaxColorDelta, 0, 255)
    }

}