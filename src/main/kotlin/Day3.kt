package de.cfe

import de.cfe.helper.BatteryPack
import de.cfe.helper.Day

class Day3 : Day(3) {
    override fun part1(input: List<String>): Any {
        var sum = 0
        for (line in input) {
            val batteryPack = BatteryPack(line)
            val batteries = batteryPack.search2()
            val number = batteries.toInt()
            sum += number
        }
        return sum
    }

    override fun part2(input: List<String>): Any {
        var sum = 0L
        for (line in input) {
            val batteryPack = BatteryPack(line)
            val batteries = batteryPack.search12()
            val number = batteries.toLong()
            sum += number
        }
        return sum
    }
}