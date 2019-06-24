package org.sert2521.minisegwayds.ui

import processing.core.PApplet

class UI<T : Box>(val root: T) {
    var update = true

    fun render(applet: PApplet) {
        if (update) {
            applet.clear()
            root.render(applet, root.marginLeft, root.marginTop)
            update = false
        }
    }
}

fun <T : Box> ui(root: T, handler: T.() -> Unit) = UI(root.apply(handler))
