package de.cfe.helper

import kotlin.system.measureTimeMillis

abstract class Day(val dayNumber: Int) {

    abstract fun part1(input: List<String>): Any
    abstract fun part2(input: List<String>): Any

    fun solveAndPrint(input: List<String>, part: Int): Unit {
        val solution = solveAndMeasure(input, part)
        Util.printSolution(dayNumber, part, solution)
    }

    fun solveAndMeasure(input: List<String>, part: Int): Solution {
        var result: Any? = null
        val took = measureTimeMillis {
            result = solve(input, part)
        }
        val solution = Solution(took, result)
        return solution
    }

    fun solve(input: List<String>, part: Int): Any {
        return when (part) {
            1 -> {
                part1(input)
            }
            2 -> {
                part2(input)
            }
            else -> {
                throw IllegalArgumentException("Invalid part $part")
            }
        }
    }
}