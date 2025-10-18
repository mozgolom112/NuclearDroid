package academy

enum class UnitLength(
    val names: List<String>,
    val multiplierToMeter: Double,
    val singularName: String,
    val pluralName: String,
) {
    Meters(listOf( "m", "meter", "meters"),1.0, singularName = "meter", pluralName = "meters"),
    Kilometers(listOf("km", "kilometer", "kilometers"), 1000.0, singularName = "kilometer", pluralName = "kilometers"),
    Centimeters(listOf("cm", "centimeter",  "centimeters"), 0.01, singularName = "centimeter", pluralName = "centimeters"),
    Millimeters(listOf( "mm", "millimeter", "millimeters"),  0.001, singularName = "millimeter", pluralName = "millimeters"),
    Miles(listOf("mi", "mile", "miles"), 1609.35, singularName = "mile", pluralName = "miles"),
    Yards(listOf("yd", "yard", "yards"), 0.9144, singularName = "yard", pluralName = "yards"),
    Feet(listOf("ft", "foot", "feet"), 0.3048, singularName = "foot", pluralName = "feet"),
    Inches(listOf("in", "inch", "inches"), 0.0254, singularName = "inch", pluralName = "inches"),
}