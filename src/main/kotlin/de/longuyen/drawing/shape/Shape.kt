package de.longuyen.drawing.shape
import de.longuyen.drawing.PopulationContext
import java.awt.Graphics

interface Shape {
    val z: Int // z-index
    val type: ShapeType
    var color: IntArray // RGBA
    fun draw(g: Graphics, populationContext: PopulationContext)
    fun copy(): Shape
}