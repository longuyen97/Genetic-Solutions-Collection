package de.longuyen.drawing.shape
import java.awt.Color
import java.awt.Graphics

class Circle(override var color: IntArray,
              var x: Int,
              var y: Int,
             override var z: Int,
              var r: Int) : Shape {
    override val type: ShapeType = ShapeType.CIRCLE

    override fun draw(g: Graphics, populationContext: PopulationContext) {
        if (populationContext.useAlpha) {
            g.color = Color(color.get(0), color.get(1), color.get(2), color.get(3))
        } else {
            g.color = Color(color.get(0), color.get(1), color.get(2))
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