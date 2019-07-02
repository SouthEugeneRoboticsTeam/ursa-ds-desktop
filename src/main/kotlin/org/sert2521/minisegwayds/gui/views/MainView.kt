package org.sert2521.minisegwayds.gui.views

import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.paint.Color
import tornadofx.*

class MainView : View("URSA Driver Station") {
    override val root = borderpane {
        top<StatusBar>()
    }
}
