package org.sert2521.minisegwayds.ui

import processing.core.PApplet

open class Box : Component() {
    var children = mutableListOf<Component>()

    var displayDirection = DisplayDirection.HORIZONTAL

    var paddingLeft = 0f
    var paddingTop = 0f
    var paddingRight = 0f
    var paddingBottom = 0f

    var spacing = 0f
    var autoSpacing = false

    fun add(component: Component) {
        children.add(component)
    }

    override fun render(applet: PApplet, x: Float, y: Float) {
        with(backgroundColor) { applet.fill(r, g, b, alpha) }
        with(borderColor) { applet.stroke(r, g, b, alpha) }
        applet.rect(x, y, width, height)
        var xOffset = x + paddingLeft
        var yOffset = y + paddingTop
        val spacing = if (autoSpacing) {
            if (displayDirection == DisplayDirection.HORIZONTAL){
                var childSpace = 0f
                children.forEach { childSpace += it.width + it.marginLeft + it.marginRight }
                ((width - paddingLeft - paddingRight) - childSpace) / (children.size - 1)
            } else {
                var childSpace = 0f
                children.forEach { childSpace += it.height + it.marginTop + it.marginBottom }
                ((height - paddingTop - paddingBottom) - childSpace) / (children.size - 1)
            }
        } else spacing
        children.forEach {
            if (displayDirection == DisplayDirection.HORIZONTAL) {
                xOffset += it.marginLeft
            } else {
                yOffset += it.marginTop
            }
            it.render(applet, xOffset, yOffset)
            if (displayDirection == DisplayDirection.HORIZONTAL) {
                xOffset += it.width + it.marginRight + spacing
            } else {
                yOffset += it.height + it.marginBottom + spacing
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
