package de.longuyen.drawing.shape
import de.longuyen.drawing.AlgorithmContext
import java.awt.Graphics

interface Shape {
    val z: Int // z-index
    val type: ShapeType
    var color: IntArray // RGBA
    fun draw(g: Graphics, algorithmContext: AlgorithmContext)
    fun copy(): Shape
}