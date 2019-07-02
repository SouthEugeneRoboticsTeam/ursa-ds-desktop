package org.sert2521.minisegwayds.gui

import com.jfoenix.controls.JFXToggleButton
import javafx.scene.Parent
import tornadofx.opcr

fun Parent.jfxToggleButton(text: String = "", op: JFXToggleButton.() -> Unit = {}) =
    opcr(this, JFXToggleButton()) {
        this.text = text
        op()
    }
