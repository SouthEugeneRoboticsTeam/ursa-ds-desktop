package org.sert2521.minisegwayds.ui

import processing.core.PApplet

open class Box : Component() {
    var children = mutableListOf<Component>()

    var displayDirection = DisplayDirection.HORIZONTAL

    var paddingLeft = Measurement(Units.PIXELS, 0f)
    var paddingTop = Measurement(Units.PIXELS, 0f)
    var paddingRight = Measurement(Units.PIXELS, 0f)
    var paddingBottom = Measurement(Units.PIXELS, 0f)

    var spacing = Measurement(Units.PIXELS, 0f)
    var autoSpacing = false

    fun add(component: Component) {
        children.add(component)
    }

    override fun render(applet: PApplet, x: Float, y: Float, parentWidth: Float, parentHeight: Float) {
        with(backgroundColor) { applet.fill(r, g, b, alpha) }
        with(borderColor) { applet.stroke(r, g, b, alpha) }
        applet.rect(x, y, width.final(parentWidth), height.final(parentHeight))
        var xOffset = x + paddingLeft.final(parentWidth)
        var yOffset = y + paddingTop.final(parentHeight)
        val spacing = if (autoSpacing) {
            if (displayDirection == DisplayDirection.HORIZONTAL){
                var childSpace = 0f
                children.forEach {
                    childSpace += it.width.final(parentWidth)
                        + it.marginLeft.final(parentWidth)
                        + it.marginRight.final(parentWidth)
                }
                ((width.final(parentWidth) - paddingLeft.final(parentWidth)
                        - paddingRight.final(parentWidth)) - childSpace) / (children.size - 1)
            } else {
                var childSpace = 0f
                children.forEach {
                    childSpace += it.height.final(parentHeight)
                        + it.marginTop.final(parentHeight)
                        + it.marginBottom.final(parentHeight)
                }
                ((height.final(parentHeight) - paddingTop.final(parentHeight)
                        - paddingBottom.final(parentHeight)) - childSpace) / (children.size - 1)
            }
        } else spacing.value
        children.forEach {
            if (displayDirection == DisplayDirection.HORIZONTAL) {
                xOffset += it.marginLeft.final(parentWidth)
            } else {
                yOffset += it.marginTop.final(parentHeight)
            }
            it.render(applet, xOffset, yOffset, width.final(parentWidth), height.final(parentHeight))
            if (displayDirection == DisplayDirection.HORIZONTAL) {
                xOffset += it.width.final(parentWidth) + it.marginRight.final(parentWidth) + spacing
            } else {
                yOffset += it.height.final(parentHeight) + it.marginBottom.final(parentHeight) + spacing
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
