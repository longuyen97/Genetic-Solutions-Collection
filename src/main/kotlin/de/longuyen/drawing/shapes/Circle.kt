package de.longuyen.drawing.shapes
import de.longuyen.drawing.core.AlgorithmContext
import java.awt.Color
import java.awt.Graphics

class Circle(override var color: IntArray,
              var x: Int,
              var y: Int,
              override var z: Int,
              var r: Int) : Shape {

    override fun draw(g: Graphics, algorithmContext: AlgorithmContext) {
        if (algorithmContext.useAlpha) {
            g.color = Color(color[0], color[1], color[2], color[3])
        } else {
            g.color = Color(color[0], color[1], color[2])
        }
        g.fillOval(x, y, r, r)
    }

    override fun copy(): Circle {
        return Circle(
                color = color.copyOf(),
                x = x,
                y = y,
                z = z,
                r = r
        )
    }
}