package org.sert2521.minisegwayds.gui

import tornadofx.Controller
import tornadofx.property

class State : Controller() {
    val enabledProperty = property(false).fxProperty
    var enabled by property { enabledProperty }
}
