package de.cfe.helper

class BatteryPack(val pack: String) {

    // Finds the best battery in the pack in the given bounds, bounds are inclusive
    fun findBestBattery(leftBound: Int, rightBound: Int): Int {
        var largestBattery = pack[leftBound]
        var largestBatteryIndex = leftBound
        for (i in leftBound..rightBound) {
            if (pack[i].digitToInt() > largestBattery.digitToInt()) {
                largestBattery = pack[i]
                largestBatteryIndex = i
            }
        }
        return largestBatteryIndex
    }

    fun search2(): String {
        val packSize = pack.length

        val leftBatteryIndex = findBestBattery(0, packSize - 2)
        val rightBatteryIndex = findBestBattery(leftBatteryIndex + 1, packSize - 1)

        return "${pack[leftBatteryIndex]}${pack[rightBatteryIndex]}"
    }

    fun search12(): String {
        val packSize = pack.length
        val batteryIndices = mutableListOf<Int>()

        for (i in 0..11) {
            // Left bound is index of next activated battery to the left, except for the battery furthest left, because it has no neighbor there
            var leftBound = i
            if (i > 0) {
                leftBound = batteryIndices[i-1] + 1
            }

            // Right bound is furthest battery to the right, leaving enough battery spaces to be activated
            var rightBound = (packSize - 12) + i

            val batteryIndex = findBestBattery(leftBound, rightBound)
            batteryIndices.add(batteryIndex)
        }
        val result = batteryIndices.map { pack[it] }.joinToString("")
        return result
    }

}