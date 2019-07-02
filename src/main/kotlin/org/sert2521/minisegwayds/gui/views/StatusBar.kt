package org.sert2521.minisegwayds.gui.views

import com.jfoenix.controls.JFXBadge
import com.jfoenix.controls.JFXButton
import com.jfoenix.controls.JFXMasonryPane
import com.jfoenix.controls.JFXToggleButton
import javafx.event.EventHandler
import javafx.scene.text.Text
import org.sert2521.minisegwayds.gui.State
import org.sert2521.minisegwayds.gui.jfxToggleButton
import tornadofx.*
import tornadofx.bind

class StatusBar : View() {
    val state: State by inject()

    override val root = vbox {
        vbox {
        }
        vbox {
            jfxToggleButton("Enable") {
                selectedProperty().bindBidirectional(state.enabledProperty)
            }
        }
    }
}
