package de.longuyen.drawing.fitness

import de.longuyen.drawing.poc.chromosome.ImageChromosome
import java.awt.image.BufferedImage
import kotlin.math.abs

class ImageDifference(private val target: BufferedImage, private val stepSize: Int): IFitness<ImageChromosome> {
    override fun compute(chromosome: ImageChromosome): Double {
        val solution = chromosome.decode()
        var error = 0.0
        (0 until solution.width step stepSize).forEach{ x ->
            (0 until solution.height step stepSize).forEach{ y ->
                val rgb = solution.getRGB(x, y)
                val rgb2 = solution.getRGB(x, y)
                error += abs((rgb and 0xFF) - (rgb2 and 0xFF))
                error += abs(((rgb shr 8) and 0xFF) - ((rgb2 shr 8) and 0xFF))
                error += abs(((rgb shr 16) and 0xFF) - ((rgb2 shr 16) and 0xFF))
            }
        }
        return error
    }
}