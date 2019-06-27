package org.sert2521.minisegwayds.gui

import javafx.stage.Stage
import org.sert2521.minisegwayds.gui.views.MainView
import tornadofx.App

class Gui : App(MainView::class) {
    override fun start(stage: Stage) {
        super.start(stage)
        stage.isMaximized = true
    }
}
