package org.sert2521.minisegwayds.ui

import processing.core.PApplet

abstract class Component {
    var width = Measurement(Units.PIXELS, 0f)
    var height = Measurement(Units.PIXELS, 0f)

    var marginLeft = Measurement(Units.PIXELS, 0f)
    var marginTop = Measurement(Units.PIXELS, 0f)
    var marginRight = Measurement(Units.PIXELS, 0f)
    var marginBottom = Measurement(Units.PIXELS, 0f)

    var backgroundColor = Color(255f, 255f, 255f, 255f)
    var borderColor = Color(0f, 0f, 0f, 0f)

    abstract fun render(applet: PApplet, x: Float, y: Float, parentWidth: Float, parentHeight: Float)
}
