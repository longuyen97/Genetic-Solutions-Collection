package de.longuyen.drawing.costs

import java.awt.Color
import java.awt.image.BufferedImage
import kotlin.math.abs

class ImageDifference(private val b1: BufferedImage, private val stepSize: Int)  : CostFunction{
    private val reds: Array<DoubleArray> = Array(b1.height) { _ -> DoubleArray(b1.width) { _ -> (0.0)} }
    private val greens: Array<DoubleArray> = Array(b1.height) { _ -> DoubleArray(b1.width) { _ -> (0.0)} }
    private val blues: Array<DoubleArray> = Array(b1.height) { _ -> DoubleArray(b1.width) { _ -> (0.0)} }

    init {
        (0 until b1.height ).forEach { y ->
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

    override fun compare(bi2: BufferedImage): Double {
        var error = 0.0
        (0 until b1.height step stepSize).forEach { y ->
            (0 until b1.width step stepSize).forEach { x ->
                val rgb = Color(bi2.getRGB(x, y))
                error += abs(reds[y][x] - rgb.red.toDouble())
                error +=  abs(blues[y][x] - rgb.blue.toDouble())
                error +=  abs(greens[y][x] - rgb.green.toDouble())
            }
        }
        return error
    }
}