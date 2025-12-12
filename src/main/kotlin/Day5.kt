package de.cfe

import de.cfe.helper.Day
import de.cfe.helper.ProductIdRange

class Day5 : Day<Pair<ProductIdRange, List<String>>>(5) {
    override fun part1(input: Pair<ProductIdRange, List<String>>): Any {
        val (productIdRange, ids) = input
        var amountOfFreshIds = 0
        for (id in ids) {
            var range = productIdRange.next
            while (true) {
                if (range!!.lowerBound < id.toLong() && range.upperBound > id.toLong()) {
                    amountOfFreshIds++
                    break
                }
                if (range.next == null) {
                    break
                }
                range = range.next
            }
        }
        return amountOfFreshIds
    }

    override fun part2(input: Pair<ProductIdRange, List<String>>): Any {
        TODO("Not yet implemented")
    }
}