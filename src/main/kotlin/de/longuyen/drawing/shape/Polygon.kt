package de.longuyen.drawing.shape

import de.longuyen.drawing.AlgorithmContext
import java.awt.Color
import java.awt.Graphics

class Polygon(override var color: IntArray,
              var x: IntArray,
              var y: IntArray,
              override var z: Int) : Shape {
    override val type: ShapeType = ShapeType.POLYGON

    override fun draw(g: Graphics, algorithmContext: AlgorithmContext) {
        if (algorithmContext.useAlpha) {
            g.color = Color(color[0], color[1], color[2], color[3])
        } else {
            g.color = Color(color[0], color[1], color[2])
        }
        g.fillPolygon(x, y, x.size)
    }

    override fun copy(): Polygon {
        return Polygon(
                color = color.copyOf(),
                x = x.copyOf(),
                y = y.copyOf(),
                z = z
        )
    }
}