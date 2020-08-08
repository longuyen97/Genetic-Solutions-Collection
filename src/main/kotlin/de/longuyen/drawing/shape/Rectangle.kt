package de.longuyen.drawing.shape

import java.awt.Color
import java.awt.Graphics

class Rectangle(override var color: IntArray,
                var x: Int,
                var y: Int,
                override var z: Int,
                var w: Int,
                var h: Int) : Shape {
    override val type: ShapeType = ShapeType.RECTANGLE

    override fun draw(g: Graphics, populationContext: PopulationContext) {
        if (populationContext.useAlpha) {
            g.color = Color(color[0], color[1], color[2], color[3])
        } else {
            g.color = Color(color[0], color[1], color[2])
        }
        g.fillRect(x, y, w, h)
    }

    override fun copy(): Rectangle {
        return Rectangle(
                color = color.copyOf(),
                x = x,
                y = y,
                z = z,
                w = w,
                h = h
        )
    }
}