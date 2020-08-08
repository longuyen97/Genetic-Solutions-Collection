package de.longuyen.drawing.shape
import de.longuyen.drawing.core.AlgorithmContext
import java.awt.Graphics

interface Shape {
    val z: Int // z-index
    var color: IntArray // RGBA
    fun draw(g: Graphics, algorithmContext: AlgorithmContext)
    fun copy(): Shape
}