package org.sert2521.minisegwayds.ui

class Measurement(val units: Units, val value: Float)

enum class Units {
    PIXELS, PERCENT
}

fun Measurement.final(parentValue: Float) = if (units == Units.PIXELS) value else (value / 100) * parentValue
