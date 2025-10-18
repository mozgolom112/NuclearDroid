package academy

fun main() {
    print("Enter a number and a measure: ")
    ConvertorInput(readln()).processCommand()
}

private class ConvertorInput(arg: String?) {
    private val input = arg ?: ""
    val count = input.split(" ")[0].toIntOrNull()
    val measuringUnit = input.split(" ").getOrElse(1) { "" }
    fun processCommand() {
        if (count == null) {
            showInvalidInputMessage()
            return
        }
        when (measuringUnit.lowercase()) {
            "km", "kilometer", "kilometers" -> convertKmToMeters(count)
            else -> showInvalidInputMessage()
        }
    }

    private fun showInvalidInputMessage() {
        println("Invalid input")
    }
}

private fun convertKmToMeters(kilometers: Int) {
    val meters = kilometers * 1000
    val kilometerUnitWord = if (kilometers == 1) "kilometer" else "kilometers"

    println("$kilometers $kilometerUnitWord is $meters meters")
}