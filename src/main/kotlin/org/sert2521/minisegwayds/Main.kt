package org.sert2521.minisegwayds

import org.sert2521.minisegwayds.ui.*
import processing.core.PApplet

val ui = ui(Box()) {
    width = 640f
    height = 480f
    paddingTop = 10f
    paddingLeft = 100f
    box {
        width = 100f
        height = 100f
        backgroundColor = Color(255f, 0f, 0f, 255f)
    }
    box {
        marginLeft = 30f
        width = 100f
        height = 100f
        backgroundColor = Color(0f, 255f, 0f, 255f)
    }
    box {
        marginLeft = 30f
        width = 100f
        height = 100f
        backgroundColor = Color(0f, 0f, 255f, 255f)
    }
}

object DriverStation : PApplet() {
    override fun settings() {
        size(640, 480)
    }

    override fun draw() {
        ui.render(this)
    }
}

fun main() {
    PApplet.runSketch(arrayOf("DriverStation"), DriverStation)
}
