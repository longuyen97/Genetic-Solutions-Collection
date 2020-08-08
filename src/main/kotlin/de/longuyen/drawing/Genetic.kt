package de.longuyen.drawing

import de.longuyen.drawing.shape.*
import java.awt.Color
import java.awt.Graphics
import java.util.*

class Genetic(private val populationContext: PopulationContext) {
    private val random = Random()

    private fun newIndividual(): Chromosome {
        val genes = mutableListOf<Shape>()
        (1..populationContext.geneCount).forEach { _ ->
            genes.add(newShape())
        }
        return Chromosome(genes, Double.MAX_VALUE)
    }

    fun newPopulation(): List<Chromosome> {
        val population = mutableListOf<Chromosome>()
        (1..this.populationContext.populationCount).forEach { _ ->
            population.add(newIndividual())
        }
        return population
    }

    fun expressDna(g: Graphics, chromosome: Chromosome) {
        g.color = Color.BLACK
        g.clearRect(0, 0, populationContext.width, populationContext.height)
        chromosome.dna.forEach { gene ->
            gene.draw(g, populationContext)
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
        val shapeIndex = random.nextInt(populationContext.allowedShapes.size)
        when (populationContext.allowedShapes[shapeIndex]) {
            ShapeType.RECTANGLE -> return newRectangle()
            ShapeType.ELLIPSE -> return newEllipse()
            ShapeType.POLYGON -> return newPolygon()
            ShapeType.PIXEL -> return newPixel()
            ShapeType.CIRCLE -> return newCircle()
        }
    }

    private fun newPolygon(): Polygon {
        val numberPoints = random.nextInt(populationContext.maxPolygonSize - 2) + 3
        val x = IntArray(numberPoints)
        val y = IntArray(numberPoints)
        (0 until numberPoints).forEach { i ->
            x[i] = random.nextInt(populationContext.width)
            y[i] = random.nextInt(populationContext.height)
        }
        val z = random.nextInt(1000)
        val color = newColor()
        return Polygon(color, x, y, z)
    }

    private fun newEllipse(): Ellipse {
        val x = random.nextInt(populationContext.width)
        val y = random.nextInt(populationContext.height)
        val z = random.nextInt(1000)
        val w = bound(random.nextInt(populationContext.width / 4), 2, populationContext.width - x)
        val h = bound(random.nextInt(populationContext.height / 4), 2, populationContext.height - y)
        val color = newColor()
        return Ellipse(color, x, y, z, w, h)
    }

    private fun newCircle(): Circle {
        val x = random.nextInt(populationContext.width)
        val y = random.nextInt(populationContext.height)
        val z = random.nextInt(1000)
        val r = bound(random.nextInt(populationContext.width / 4), 2, (populationContext.width + populationContext.height) / 2)
        val color = newColor()
        return Circle(color, x, y, z, r)
    }

    private fun newPixel(): Pixel {
        val x = random.nextInt(populationContext.width / populationContext.pixelSize) * populationContext.pixelSize
        val y = random.nextInt(populationContext.height / populationContext.pixelSize) * populationContext.pixelSize
        val z = random.nextInt(1000)
        val color = newColor()
        return Pixel(color, x, y, z, populationContext.pixelSize)
    }

    private fun newRectangle(): Rectangle {
        val x = random.nextInt(populationContext.width)
        val y = random.nextInt(populationContext.height)
        val w = bound(random.nextInt(populationContext.width / 4), 2, populationContext.width - x)
        val h = bound(random.nextInt(populationContext.height / 4), 2, populationContext.height - y)
        val z = random.nextInt(1000)
        val color = newColor()
        return Rectangle(color, x, y, z, w, h)
    }

}