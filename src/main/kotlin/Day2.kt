package de.cfe

import de.cfe.helper.Day
import de.cfe.helper.ProductIdChecker

class Day2 : Day(2) {

    override fun part1(input: List<String>): Any {
        val allInvalidIds: MutableList<Long?> = ArrayList<Long?>()
        for (range in input) {
            val bounds = range.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val lower = bounds[0]
            val upper = bounds[1]

            val invalidIds: MutableList<Long?> = ProductIdChecker.checkRange(lower, upper, 1)
            allInvalidIds.addAll(invalidIds)
        }

        return allInvalidIds.stream().mapToLong { obj: Long? -> obj!! }.sum()
    }

    override fun part2(input: List<String>): Any {
        val allInvalidIds: MutableList<Long?> = java.util.ArrayList<Long?>()
        for (range in input) {
            val bounds = range.split("-".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            val lower = bounds[0]
            val upper = bounds[1]

            val invalidIds = ProductIdChecker.checkRange(lower, upper, 2)
            allInvalidIds.addAll(invalidIds)
        }

        return allInvalidIds.stream().mapToLong { obj: Long? -> obj!! }.sum()
    }
}