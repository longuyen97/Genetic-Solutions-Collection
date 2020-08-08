
package de.longuyen.drawing.shape

import java.awt.Color
import java.awt.Rectangle
import java.awt.image.BufferedImage
import kotlin.math.abs

class ConstraintedImageDifference(
    private val b1: BufferedImage,
    private val stepSize: Int,
    private val priorityRegion: Rectangle,
    private val priorityMultiplier: Double = 10.0
) {
    private val reds: Array<DoubleArray> = Array(b1.height) { _ -> DoubleArray(b1.width) { _ -> (0.0) } }
    private val greens: Array<DoubleArray> = Array(b1.height) { _ -> DoubleArray(b1.width) { _ -> (0.0) } }
    private val blues: Array<DoubleArray> = Array(b1.height) { _ -> DoubleArray(b1.width) { _ -> (0.0) } }

    init {
        (0 until b1.height).forEach { y ->
            val red = DoubleArray(b1.width)
            val green = DoubleArray(b1.width)
            val blue = DoubleArray(b1.width)
            (0 until b1.width).forEach { x ->
                val rgb = Color(b1.getRGB(x, y))
                red[x] = rgb.red.toDouble()
                green[x] = rgb.green.toDouble()
                blue[x] = rgb.blue.toDouble()
            }
            reds[y] = red
            greens[y] = green
            blues[y] = blue
        }
    }

    fun compare(bi2: BufferedImage): Double {
        var error = 0.0
        (0 until bi2.height step stepSize).forEach { y ->
            (0 until bi2.width step stepSize).forEach { x ->
                val rgb = Color(bi2.getRGB(x, y))
                var localError = 0.0
                localError += abs(reds[y][x] - rgb.red.toDouble())
                localError += abs(blues[y][x] - rgb.blue.toDouble())
                localError += abs(greens[y][x] - rgb.green.toDouble())
                if (x >= priorityRegion.x && x <= priorityRegion.x + priorityRegion.width && y >= priorityRegion.y && x <= priorityRegion.y + priorityRegion.height) {
                    localError /= priorityMultiplier
                }
                error += localError
            }
        }
        return error
    }
}