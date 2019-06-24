package org.sert2521.minisegwayds.ui

import processing.core.PApplet

class UI<T : Box>(val root: T) {
    var update = true

    fun render(applet: PApplet) {
        if (update) {
            applet.clear()
            root.render(
                applet,
                if (root.marginLeft.units == Units.PIXELS) root.marginLeft.value
                else (root.marginLeft.value / 100) * applet.width,
                if (root.marginTop.units == Units.PIXELS) root.marginLeft.value
                else (root.marginTop.value / 100) * applet.height,
                applet.width.toFloat(),
                applet.height.toFloat()
            )
            update = false
        }
    }
}

fun <T : Box> ui(root: T, handler: T.() -> Unit) = UI(root.apply(handler))
