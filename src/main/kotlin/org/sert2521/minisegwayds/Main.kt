package org.sert2521.minisegwayds

import org.sert2521.minisegwayds.ui.*
import processing.core.PApplet

val ui = ui(Box()) {
    width = Measurement(Units.PIXELS, 640f)
    height = Measurement(Units.PIXELS, 480f)
    box {
        width = Measurement(Units.PERCENT, 10f)
        height = Measurement(Units.PERCENT, 10f)
        backgroundColor = Color(255f, 0f, 0f, 255f)
    }
    box {
        width = Measurement(Units.PERCENT, 40f)
        height = Measurement(Units.PERCENT, 40f)
        backgroundColor = Color(0f, 255f, 0f, 255f)
    }
    box {
        width = Measurement(Units.PERCENT, 50f)
        height = Measurement(Units.PERCENT, 50f)
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
