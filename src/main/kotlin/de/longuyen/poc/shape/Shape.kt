package de.longuyen.poc.shape
import java.awt.Graphics

interface Shape {
    val z: Int // z-index
    val type: ShapeType
    var color: IntArray // RGBA
    fun draw(g: Graphics, populationContext: PopulationContext)
    fun copy(): Shape
}