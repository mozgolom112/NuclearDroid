package academy

enum class UnitCategory {
    LENGTH,
    MASS
}

enum class Unit(
    val names: List<String>,
    val multiplierToSI: Double,
    val singularName: String,
    val pluralName: String,
    val category: UnitCategory,
) {
    // LENGTH multiplier to Meters
    Meters(listOf("m", "meter", "meters"), 1.0, singularName = "meter", pluralName = "meters", UnitCategory.LENGTH),
    Kilometers(listOf("km", "kilometer", "kilometers"), 1000.0, singularName = "kilometer", pluralName = "kilometers", UnitCategory.LENGTH),
    Centimeters(listOf("cm", "centimeter", "centimeters"), 0.01, singularName = "centimeter", pluralName = "centimeters", UnitCategory.LENGTH),
    Millimeters(listOf("mm", "millimeter", "millimeters"), 0.001, singularName = "millimeter", pluralName = "millimeters", UnitCategory.LENGTH),
    Miles(listOf("mi", "mile", "miles"), 1609.35, singularName = "mile", pluralName = "miles", UnitCategory.LENGTH),
    Yards(listOf("yd", "yard", "yards"), 0.9144, singularName = "yard", pluralName = "yards", UnitCategory.LENGTH),
    Feet(listOf("ft", "foot", "feet"), 0.3048, singularName = "foot", pluralName = "feet", UnitCategory.LENGTH),
    Inches(listOf("in", "inch", "inches"), 0.0254, singularName = "inch", pluralName = "inches", UnitCategory.LENGTH),

    // MASS multiplier to kilogram
    Grams(listOf("g", "gram", "grams"), 0.001, singularName = "gram", pluralName = "grams", UnitCategory.MASS),
    Kilograms(listOf("kg", "kilogram", "kilograms"), 1.0, singularName = "kilogram", pluralName = "kilograms", UnitCategory.MASS),
    Milligrams(listOf("mg", "milligram", "milligrams"), 0.000001, singularName = "milligram", pluralName = "milligrams", UnitCategory.MASS),
    Pounds(listOf("lb", "pound", "pounds"), 0.45359237, singularName = "pound", pluralName = "pounds", UnitCategory.MASS),
    Ounces(listOf("oz", "ounce", "ounces"), 0.02835, singularName = "ounce", pluralName = "ounces", UnitCategory.MASS);

    companion object {
        fun fromInput(input: String): Unit? {
            val normalized = input.trim().lowercase()
            return entries.firstOrNull { normalized in it.names }
        }
    }
}