package de.cfe

import de.cfe.helper.Day
import de.cfe.helper.RollsGrid

class Day4 : Day<List<String>>(4) {
    override fun part1(input: List<String>): Any {
        val rollsGrid = RollsGrid(input as MutableList<String>)
        rollsGrid.checkGrid(listOf('@', 'x'))
        return rollsGrid.countRemovableRolls()
    }

    override fun part2(input: List<String>): Any {
        // This is basically the same thing, but a 'x' doesn't count as a neighbor anymore
        // And we need to iterate multiple times, as new rolls can be made available each check
        val rollsGrid = RollsGrid(input as MutableList<String>)

        var marked = 1
        while (marked != 0) {
            marked = rollsGrid.checkGrid(listOf('@'))
        }

        return rollsGrid.countRemovableRolls()
    }
}