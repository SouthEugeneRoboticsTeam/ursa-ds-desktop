package org.sert2521.minisegwayds.ui

import processing.core.PApplet

class UI<T : Box>(val root: T) {
    fun render(applet: PApplet) {
        applet.clear()
        root.render(applet, root.marginLeft, root.marginTop)
    }
}

fun <T : Box> ui(root: T, handler: T.() -> Unit) = UI(root.apply(handler))
