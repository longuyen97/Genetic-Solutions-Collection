package com.kennycason.genetic.draw.fitness

import de.longuyen.poc.chromosome.ImageChromosome
import de.longuyen.poc.fitness.IFitness
import java.awt.Rectangle
import java.awt.image.BufferedImage
import kotlin.math.abs

/**
 * Created by kenny on 5/23/16.
 *
 * Like the standard image difference fitness function except it will prioritize a specific region of the image to evolve.
 */
class PriorityRegionImageDifference(val target: BufferedImage, private val stepSize: Int, private val priorityRegion: Rectangle, private val priorityMultiplier: Double = 10.0): IFitness<ImageChromosome> {
    override fun compute(chromosome: ImageChromosome): Double {
        var error = 0.0
        val solution = chromosome.decode()
        (0 until solution.width step stepSize).forEach{ x ->
            (0 until solution.height step stepSize).forEach{ y ->
                val rgb = solution.getRGB(x, y)
                val rgb2 = target.getRGB(x, y)
                var localError = 0.0
                localError += abs((rgb and 0xFF) - (rgb2 and 0xFF))
                localError += abs(((rgb shr 8) and 0xFF) - ((rgb2 shr 8) and 0xFF))
                localError += abs(((rgb shr 16) and 0xFF) - ((rgb2 shr 16) and 0xFF))
                if (x >= priorityRegion.x && x <= priorityRegion.x + priorityRegion.width
                    && y >= priorityRegion.y && x <= priorityRegion.y + priorityRegion.height) {
                    localError /= priorityMultiplier
                }

                error += localError
            }
        }
        return error
    }
}