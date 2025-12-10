package de.cfe.helper

class RollsGrid(val grid: MutableList<String>) {

    var neighbourChecks = 0

    fun fourOrMoreNeighbours(row: Int, column: Int, countsAsNeighbors: List<Char>): Boolean {
        var amountOfNeighbours = 0
        for (rowIterator in row-1..row+1) {
            for (columnIterator in column-1..column+1) {
                // In this case it is the cell itself
                if (rowIterator == row && columnIterator == column) continue

                // In this case it is out of bounds
                if (rowIterator !in 0..<grid.size || columnIterator !in 0..<grid[0].length) continue

                if (grid[rowIterator][columnIterator] in countsAsNeighbors) {
                    amountOfNeighbours++
                }
                neighbourChecks++
            }
        }
        return amountOfNeighbours >= 4
    }

    fun checkGrid(countsAsNeighbors: List<Char>): Int {
        val gridWidth = grid[0].length - 1
        val gridHeight = grid.size - 1
        var markedThisRun = 0

        for (column in 0..gridWidth) {
            for (row in 0..gridHeight) {
                // Is not a paper roll or is already marked / removed
                if (grid[row][column] == '.' || grid[row][column] == 'x') continue
                if (!fourOrMoreNeighbours(row, column, countsAsNeighbors)) {
                    mark(row, column)
                    markedThisRun++
                }
            }
        }
        return markedThisRun
    }

    fun mark(row: Int, column: Int) {
        val rowChars = grid[row].toCharArray()
        rowChars[column] = 'x'
        grid[row] = String(rowChars)
    }

    fun countRemovableRolls(): Int {
        return grid.sumOf { row -> row.count { it == 'x' } }
    }

}