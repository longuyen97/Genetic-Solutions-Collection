package de.longuyen.poc.shape

import java.awt.Rectangle
import java.awt.image.BufferedImage
import kotlin.math.abs

class ConstraintImageDifference(private val stepSize: Int, private val priorityRegion: Rectangle, private val priorityMultiplier: Double = 10.0) {
    fun compare(bi: BufferedImage, bi2: BufferedImage): Double {
        var error = 0.0
        (0 until bi.width step stepSize).forEach { x ->
            (0 until bi.height step stepSize).forEach { y ->
                val rgb = bi.getRGB(x, y)
                val rgb2 = bi2.getRGB(x, y)
                var localError = 0.0
                localError += abs((rgb and 0xFF) - (rgb2 and 0xFF))
                localError += abs((rgb shr 8 and 0xFF) - (rgb2 shr 8 and 0xFF))
                localError += abs((rgb shr 16 and 0xFF) - (rgb2 shr 16 and 0xFF))
                if (x >= priorityRegion.x && x <= priorityRegion.x + priorityRegion.width
                    && y >= priorityRegion.y && x <= priorityRegion.y + priorityRegion.height
                ) {
                    localError /= priorityMultiplier
                }

                error += localError
            }
        }
        return error
    }
}
