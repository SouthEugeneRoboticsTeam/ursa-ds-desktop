package org.sert2521.minisegwayds.ui

import processing.core.PApplet

open class Box : Component() {
    var children = mutableListOf<Component>()

    var displayDirection = DisplayDirection.HORIZONTAL

    fun add(component: Component) {
        children.add(component)
    }

    override fun render(applet: PApplet, x: Float, y: Float) {
        with(backgroundColor) { applet.fill(r, g, b, alpha) }
        with(borderColor) { applet.stroke(r, g, b, alpha) }
        applet.rect(x, y, width, height)
        var xOffset = x
        var yOffset = y
        children.forEach {
            it.render(applet, xOffset, yOffset)
            if (displayDirection == DisplayDirection.HORIZONTAL) {
                xOffset += it.width
            } else {
                yOffset += it.height
            }
        }
    }
}

fun Box.box(handler: Box.() -> Unit) {
    add(Box().apply(handler))
}

enum class DisplayDirection {
    HORIZONTAL, VERTICAL
}