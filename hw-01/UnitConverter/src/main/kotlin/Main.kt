package academy

import kotlin.math.abs

fun main() {
    print("Enter a number and a measure: ")
    ConvertorInput(readln()).processCommand()
}

private class ConvertorInput(arg: String?) {
    private val input = arg ?: ""
    val countInput = input.split(" ")[0]
    val measuringUnitInput = input.split(" ").getOrElse(1) { "" }
    fun processCommand() {
        val count = countInput.toDoubleOrNull()
        if (count == null || count < 0) {
            showInvalidInputMessage()
            return
        }

        val measuringUnit = when (measuringUnitInput.lowercase()) {
            in UnitLength.Meters.names -> UnitLength.Meters
            in UnitLength.Kilometers.names -> UnitLength.Kilometers
            in UnitLength.Centimeters.names -> UnitLength.Centimeters
            in UnitLength.Millimeters.names -> UnitLength.Millimeters
            in UnitLength.Miles.names -> UnitLength.Miles
            in UnitLength.Yards.names -> UnitLength.Yards
            in UnitLength.Feet.names -> UnitLength.Feet
            in UnitLength.Inches.names -> UnitLength.Inches
            else -> null
        }
        if (measuringUnit == null) {
            showInvalidInputMessage("Unknown unit $measuringUnitInput")
            return
        }

        convertToMetersAndPrint(count, measuringUnit)
    }

    private fun showInvalidInputMessage(extraMessageInfo: String = "") {
        val messageError = "Invalid input" + if (extraMessageInfo.isNotBlank()) ": $extraMessageInfo" else ""
        println(messageError)
    }
}

private fun convertToMetersAndPrint(amount: Double, unitLength: UnitLength) {
    val meters = amount * unitLength.multiplierToMeter
    val unitLengthWord = if (abs(amount - 1.0) < 0.0001) unitLength.singularName else unitLength.pluralName
    println("$amount $unitLengthWord is $meters meters")
}