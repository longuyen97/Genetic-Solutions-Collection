package de.longuyen.drawing.core

import de.longuyen.drawing.shape.*
import java.awt.Color
import java.awt.Graphics
import java.lang.IllegalArgumentException
import java.util.*

class PopulationBuilder(private val algorithmContext: AlgorithmContext) {
    private val random = Random()

    private fun newIndividual(): Chromosome {
        val genes = mutableListOf<Shape>()
        (1..algorithmContext.geneCount).forEach { _ ->
            genes.add(newShape())
        }
        return Chromosome(genes, Double.MAX_VALUE)
    }

    fun newPopulation(): List<Chromosome> {
        val population = mutableListOf<Chromosome>()
        (1..this.algorithmContext.populationCount).forEach { _ ->
            population.add(newIndividual())
        }
        return population
    }

    fun expressDna(g: Graphics, chromosome: Chromosome) {
        g.color = Color.BLACK
        g.clearRect(0, 0, algorithmContext.width, algorithmContext.height)
        chromosome.dna.forEach { gene ->
            gene.draw(g, algorithmContext)
        }
    }

    fun bound(value: Int, min: Int, max: Int): Int {
        if (value < min) { return min; }
        if (value > max) { return max; }
        return value
    }

    private fun newColor(): IntArray {
        val color = IntArray(4)
        color[0] = random.nextInt(256)
        color[1] = random.nextInt(256)
        color[2] = random.nextInt(256)
        color[3] = random.nextInt(256)
        return color
    }

    private fun newShape(): Shape {
        val shapeIndex = random.nextInt(algorithmContext.allowedShapes.size)
        val name = algorithmContext.allowedShapes[shapeIndex]
        when (name) {
            Rectangle::class.java.simpleName -> return newRectangle()
            Ellipse::class.java.simpleName -> return newEllipse()
            Polygon::class.java.simpleName -> return newPolygon()
            Pixel::class.java.simpleName -> return newPixel()
            Circle::class.java.simpleName -> return newCircle()
        }
        throw IllegalArgumentException("Shape is not allowed: $name")
    }

    private fun newPolygon(): Polygon {
        val numberPoints = random.nextInt(algorithmContext.maxPolygonSize - 2) + 3
        val x = IntArray(numberPoints)
        val y = IntArray(numberPoints)
        (0 until numberPoints).forEach { i ->
            x[i] = random.nextInt(algorithmContext.width)
            y[i] = random.nextInt(algorithmContext.height)
        }
        val z = random.nextInt(1000)
        val color = newColor()
        return Polygon(color, x, y, z)
    }

    private fun newEllipse(): Ellipse {
        val x = random.nextInt(algorithmContext.width)
        val y = random.nextInt(algorithmContext.height)
        val z = random.nextInt(1000)
        val w = bound(random.nextInt(algorithmContext.width / 4), 2, algorithmContext.width - x)
        val h = bound(random.nextInt(algorithmContext.height / 4), 2, algorithmContext.height - y)
        val color = newColor()
        return Ellipse(color, x, y, z, w, h)
    }

    private fun newCircle(): Circle {
        val x = random.nextInt(algorithmContext.width)
        val y = random.nextInt(algorithmContext.height)
        val z = random.nextInt(1000)
        val r = bound(random.nextInt(algorithmContext.width / 4), 2, (algorithmContext.width + algorithmContext.height) / 2)
        val color = newColor()
        return Circle(color, x, y, z, r)
    }

    private fun newPixel(): Pixel {
        val x = random.nextInt(algorithmContext.width / algorithmContext.pixelSize) * algorithmContext.pixelSize
        val y = random.nextInt(algorithmContext.height / algorithmContext.pixelSize) * algorithmContext.pixelSize
        val z = random.nextInt(1000)
        val color = newColor()
        return Pixel(color, x, y, z, algorithmContext.pixelSize)
    }

    private fun newRectangle(): Rectangle {
        val x = random.nextInt(algorithmContext.width)
        val y = random.nextInt(algorithmContext.height)
        val w = bound(random.nextInt(algorithmContext.width / 4), 2, algorithmContext.width - x)
        val h = bound(random.nextInt(algorithmContext.height / 4), 2, algorithmContext.height - y)
        val z = random.nextInt(1000)
        val color = newColor()
        return Rectangle(color, x, y, z, w, h)
    }

}