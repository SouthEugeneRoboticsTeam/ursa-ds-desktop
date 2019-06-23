package org.sert2521.minisegwayds.ui

import processing.core.PApplet

open class Box : Component() {
    var children = mutableListOf<Component>()

    var displayDirection = DisplayDirection.HORIZONTAL

    var paddingLeft = 0f
    var paddingTop = 0f
    var paddingRight = 0f
    var paddingBottom = 0f

    fun add(component: Component) {
        children.add(component)
    }

    override fun render(applet: PApplet, x: Float, y: Float) {
        with(backgroundColor) { applet.fill(r, g, b, alpha) }
        with(borderColor) { applet.stroke(r, g, b, alpha) }
        applet.rect(x, y, width, height)
        var xOffset = x + paddingLeft
        var yOffset = y + paddingTop
        children.forEach {
            if (displayDirection == DisplayDirection.HORIZONTAL) {
                xOffset += it.marginLeft
            } else {
                yOffset += it.marginTop
            }
            it.render(applet, xOffset, yOffset)
            if (displayDirection == DisplayDirection.HORIZONTAL) {
                xOffset += it.width + it.marginRight
            } else {
                yOffset += it.height + it.marginBottom
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
