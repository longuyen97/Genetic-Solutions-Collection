package de.longuyen.drawing.shape

import de.longuyen.drawing.core.AlgorithmContext
import java.awt.Color
import java.awt.Graphics

class Pixel(override var color: IntArray,
            var x: Int,
            var y: Int,
            override var z: Int,
            private var dim: Int) : Shape {

    override fun draw(g: Graphics, algorithmContext: AlgorithmContext) {
        if (algorithmContext.useAlpha) {
            g.color = Color(color[0], color[1], color[2], color[3])
        } else {
            g.color = Color(color[0], color[1], color[2])
        }
        g.fillRect(x, y, dim, dim)
    }

    override fun copy(): Pixel {
        return Pixel(
                color = color.copyOf(),
                x = x,
                y = y,
                z = z,
                dim = dim
        )
    }
}