package org.sert2521.minisegwayds.ui

import processing.core.PApplet

abstract class Component {
    var width = 0f
    var height = 0f

    var backgroundColor = Color(255f, 255f, 255f, 255f)
    var borderColor = Color(0f, 0f, 0f, 0f)

    abstract fun render(applet: PApplet, x: Float, y: Float)
}
