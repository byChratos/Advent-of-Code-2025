package de.cfe

import de.cfe.helper.Day
import de.cfe.helper.Dial

class Day1 : Day<List<String>>(1) {
    override fun part1(input: List<String>): Any {
        val dial = Dial()

        for (line in input) {
            // Parse input line
            val direction: Char = line[0]
            val steps = line.substring(1).toInt()

            // Move dial
            val step: Int = if (direction == 'R') {
                1
            } else {
                -1
            }
            dial.step(steps, step)
        }

        return dial.endOnZero
    }

    override fun part2(input: List<String>): Any {
        val dial = Dial()

        for (line in input) {
            // Parse input line
            val direction: Char = line[0]
            val steps = line.substring(1).toInt()

            // Move dial
            val step: Int = if (direction == 'R') {
                1
            } else {
                -1
            }

            dial.step(steps, step)
        }

        return dial.endOnZero + dial.loops
    }

}