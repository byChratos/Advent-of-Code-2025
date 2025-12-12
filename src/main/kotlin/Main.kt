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

fun solveThirdDay() {
    val day = Day3()
    val input = Util.getLinesAsListItems("/3.txt")
    day.solveAndPrint(input, 1)
    day.solveAndPrint(input, 2)
}

fun solveFourthDay() {
    val day = Day4()
    val input = Util.getLinesAsListItems("/4.txt")
    day.solveAndPrint(input, 1)
    day.solveAndPrint(input, 2)
}

fun solveFifthDay() {
    val day = Day5()
    val (idRanges, ids) = Util.getIdRangesAndIds("/5.txt")
    day.solveAndPrint(idRanges to ids, 1)
    day.solveAndPrint(idRanges to ids, 2) //TODO overlaps in range.next und range jeweils?
}

fun main() {
    solveFifthDay()
}