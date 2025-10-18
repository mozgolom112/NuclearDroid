# About

When you travel, everything changes: people, languages, time zones, and even units. It may be difficult to read the temperature in Fahrenheit when you’ve always used Celsius, or to measure yourself in kilos if you’ve only used pounds. It’s no easy matter, though a nice unit converter could certainly help! In this project, you will write a converter that handles distance, weight, and temperature units – all the traveller’s essentials.

[Link to the project](https://hyperskill.org/projects/70)

# Stage 1/5
## Description
Humans use a whole variety of units of measurement depending on the purpose or the country. When you need to convert something from one unit to another, it is not very convenient to calculate it in your head. Let's create a really useful application that will perform these tedious calculations for us!

In this stage, you will take your first step in creating a program that converts length, weight, and temperature from one common unit of measurement to another. To begin with, let's simply print some exemplary conversions.

## Objectives
Print exactly the same lines as shown in the example below.

In this stage there is no need for conversions. Simply print the string(s) exactly as written bellow.

## Example
```
145 centimeters is 1.45 meters
2 miles is 3.2187 kilometers
5.5 inches is 139.7 millimeters
12 degrees Celsius is 53.6 degrees Fahrenheit
3 pounds is 1.360776 kilograms
```

# Stage 2/5

## Description
The examples you've printed are great, but they are not really helpful. Let's take a step further and create a program that converts kilometers to meters. Remember that one kilometer equals exactly 1000 meters.

The program should prompt the user to enter the number of kilometers with the following message: "Enter a number and a measure: ". The user should input a number and a unit of measurement, for example, 2 km or 2 kilometers. Note that the units of measurement should be case insensitive, so "km", "KM", and "kM" should work just as fine as "km".

The program should then output the equivalent of x kilometers in meters in the following format: x kilometers is y meters.

If the name of the unit of measurement is entered incorrectly, the program should display: Wrong input.

## Objectives
1. The program should convert the given number of kilometers to meters.
2. The user can input "km", "kilometer" or "kilometers".
3. The program should ask the user for input only once, not infinitely.
4. If the value is 1, the name of the unit must be singular, otherwise, plural: "1 kilometer" but "2 kilometers".
5. It is guaranteed that the number of kilometers is an integer.
6. If the name of the unit of measurement is entered incorrectly, the program should display: Wrong input.

## Examples
Example 1:
```
Enter a number and a measure: 25 km
25 kilometers is 25000 meters
```
Example 2:
```
Enter a number and a measure: 1 kiLOmeter
1 kilometer is 1000 meters
```
Example 3:
```
Enter a number and a measure: 5 miles
Wrong input
```

# Stage 3/5

## Description
There are many different units of length: feet, inches, yards, centimeters, and others. In this stage, the program should convert these common units of length to meters.

The user should input a number and a unit of measurement, for example, 2 km or 2 kilometers. Note that the units of measurement should be case insensitive, so "Meters", "METERS", and "mEtErS" should work just as fine as "meters".

Your program should support the following units:

- Meters: the user can input "m", "meter", or "meters".

- Kilometers: the user can input "km", "kilometer", or "kilometers".

- Centimeters: the user can input "cm", "centimeter", or "centimeters".

- Millimeters: the user can input "mm", "millimeter", or "millimeters".

- Miles: the user can input "mi", "mile", or "miles".

- Yards: the user can input "yd", "yard", or "yards".

- Feet: the user can input "ft", "foot", or "feet".

- Inches: the user can input "in", "inch", or "inches".

For these units, use the following conversion rates:

- One meter equals 1 meter.

- One kilometer equals 1000 meters.

- One centimeter equals 0.01 meters.

- One millimeter equals 0.001 meters.

- One mile equals 1609.35 meters.

- One yard equals 0.9144 meters.

- One foot equals 0.3048 meters.

- One inch equals 0.0254 meters.
  
The user can enter the wrong unit of measure. In this case, your program should print: Wrong input. Unknown unit $inputUnit.

## Objectives
Your program should be able to convert all the supported units to meters.
The output should contain the full names of the units.
If the value is 1.0, the name of the unit must be singular, otherwise, plural, for example, "1.0 meter" but "1.1 meters".
The program should ask the user for input only once, not infinitely.

## Examples
Example 1:
```
Enter a number and a measure of length: 1 m
1.0 meter is 1.0 meter
```
Example 2:
```
Enter a number and a measure of length: 1000 millimeters
1000.0 millimeters is 1.0 meter
```
Example 3:
```
Enter a number and a measure of length: 12.9 feet
12.9 feet is 3.9319200000000003 meters
```
Example 4:
```
Enter a number and a measure of length: 1 miles
1.0 mile is 1609.35 meters
```