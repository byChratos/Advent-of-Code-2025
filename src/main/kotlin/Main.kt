package de.cfe

import de.cfe.helper.Util

fun solveFirstDay() {
    val day = Day1()
    val input = Util.getLinesAsListItems("/1.txt")
    day.solveAndPrint(input, 1)
    day.solveAndPrint(input, 2)
}

fun solveSecondDay() {
    val day = Day2()
    val input = Util.getCommaItemsAsList("/2.txt")
    day.solveAndPrint(input, 1)
    day.solveAndPrint(input, 2)
}

fun main() {
    solveSecondDay()
}