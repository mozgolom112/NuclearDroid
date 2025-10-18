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

    fun processCommand() {
        // start with parse

        // Expected format: "<number> <unit> <to/in> <unit>"
        val words = input.trim().split(" ").filter { it.isNotBlank() }

        if (words.size < 4) {
            println("Parse error")
            return
        }

        val count = words[0].toDoubleOrNull()
        if (count == null) {
            println("Parse error")
            return
        }

        // Собираем возможные имена единиц ("degree celsius" и т.п.)
        val fromUnitInput = parseUnitName(words, 1)
        val toUnitInput = parseUnitName(words, words.indexOfFirst { it.lowercase() in listOf("to", "in") } + 1)

        val fromUnit = Unit.fromInput(fromUnitInput)
        val toUnit = Unit.fromInput(toUnitInput)

        if (fromUnit == null || toUnit == null) {
            println("Parse error")
            return
        }

        // Checking negative values for length and mass
        if (count < 0) {
            when (fromUnit.category) {
                UnitCategory.MASS -> {
                    println("Weight shouldn't be negative")
                    return
                }
                UnitCategory.LENGTH -> {
                    println("Length shouldn't be negative")
                    return
                }
                UnitCategory.TEMPERATURE -> {}
            }
        }

        convertAndPrint(count, fromUnit, toUnit)
    }

    private fun parseUnitName(words: List<String>, startIndex: Int): String {
        // Try find "degree"/"degrees" + "celsius"/"fahrenheit"
        return when {
            startIndex + 1 < words.size && words[startIndex].lowercase().startsWith("degree") -> {
                words[startIndex] + " " + words[startIndex + 1]
            }

            else -> words.getOrElse(startIndex) { "" }
        }
    }
}

private fun convertAndPrint(amountFrom: Double, unitFrom: Unit, unitTo: Unit) {
    if (unitFrom.category != unitTo.category) {
        println("Conversion from ${unitFrom.pluralName} to ${unitTo.pluralName} is impossible")
        return
    }

    val amountTo = when (unitFrom.category) {
        UnitCategory.TEMPERATURE -> convertTemperature(amountFrom, unitFrom, unitTo)
        else -> amountFrom * unitFrom.multiplierToSI / unitTo.multiplierToSI
    }

    val unitFromWord = if (abs(amountFrom - 1.0) < 0.0001) unitFrom.singularName else unitFrom.pluralName
    val unitToWord = if (abs(amountTo - 1.0) < 0.0001) unitTo.singularName else unitTo.pluralName

    println("$amountFrom $unitFromWord is $amountTo $unitToWord")
}

private fun convertTemperature(value: Double, fromUnit: Unit, toUnit: Unit): Double = when (fromUnit to toUnit) {
    Unit.Celsius to Unit.Fahrenheit -> value * 9 / 5 + 32
    Unit.Fahrenheit to Unit.Celsius -> (value - 32) * 5 / 9

    Unit.Celsius to Unit.Kelvin -> value + 273.15
    Unit.Kelvin to Unit.Celsius -> value - 273.15

    Unit.Fahrenheit to Unit.Kelvin -> (value + 459.67) * 5 / 9
    Unit.Kelvin to Unit.Fahrenheit -> value * 9 / 5 - 459.67

    else -> value
}