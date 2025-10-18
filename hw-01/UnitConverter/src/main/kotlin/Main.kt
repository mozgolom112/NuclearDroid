package academy

import kotlin.math.abs

fun main() {
    print("Enter what you want to convert (or exit): ")
    var input = readln()
    while (input.trim().lowercase() != "exit") {
        ConvertorInput(input).processCommand()
        print("Enter what you want to convert (or exit): ")
        input = readln()
    }
}

private class ConvertorInput(arg: String?) {
    private val input = arg ?: ""
    val countInput = input.split(" ")[0]
    val fromUnitInput = input.split(" ").getOrElse(1) { "" }
    val toUnitInput = input.split(" ").getOrElse(3) { "" }
    fun processCommand() {
        val count = countInput.toDoubleOrNull()
        if (count == null || count < 0) {
            showInvalidInputMessage()
            return
        }

        val fromUnit = Unit.fromInput(fromUnitInput)
        val toUnit = Unit.fromInput(toUnitInput)

        if (fromUnit == null) {
            val unitString = if (fromUnitInput.isNullOrEmpty()) "???" else fromUnitInput
            showInvalidInputMessage("Unknown unit $unitString")
            return
        }

        if (toUnit == null) {
            val unitString = if (toUnitInput.isNullOrEmpty()) "???" else toUnitInput
            showInvalidInputMessage("Unknown unit $unitString")
            return
        }

        convertAndPrint(count, fromUnit, toUnit)
    }

    private fun showInvalidInputMessage(extraMessageInfo: String = "") {
        val messageError = "Invalid input" + if (extraMessageInfo.isNotBlank()) ": $extraMessageInfo" else ""
        println(messageError)
    }
}

private fun convertAndPrint(amountFrom: Double, unitFrom: Unit, unitTo: Unit) {
    if (unitFrom.category != unitTo.category) {
        println("Conversion from ${unitFrom.pluralName} to ${unitTo.pluralName} is impossible")
        return
    }

    val amountTo = amountFrom * unitFrom.multiplierToSI / unitTo.multiplierToSI

    val unitFromWord = if (abs(amountFrom - 1.0) < 0.0001) unitFrom.singularName else unitFrom.pluralName
    val unitToWord = if (abs(amountTo - 1.0) < 0.0001) unitTo.singularName else unitTo.pluralName

    println("$amountFrom $unitFromWord is $amountTo $unitToWord")
}