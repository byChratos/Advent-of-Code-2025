package de.cfe.helper

import java.io.IOException
import java.net.URISyntaxException
import java.net.URL
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

class Util {
    companion object {
        fun printSolution(day: Int, part: Int, solution: Solution) {
            println("Solution Day " + day + " Part " + part + ": \"" + solution.answer + "\" took " + solution.took + "ms")
        }

        @Throws(IOException::class, URISyntaxException::class)
        fun getLinesAsListItems(filename: String): MutableList<String> {
            val url: URL = checkNotNull(Util::class.java.getResource(filename))
            val path = Paths.get(url.toURI())
            return Files.readAllLines(path)
        }

        @Throws(IOException::class, URISyntaxException::class)
        fun getCommaItemsAsList(filename: String): MutableList<String> {
            val url: URL = checkNotNull(Util::class.java.getResource(filename))
            val path = Paths.get(url.toURI())
            val inputLine = Files.readString(path)
            return listOf(*inputLine.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) as MutableList<String>
        }

        @Throws(IOException::class, URISyntaxException::class)
        fun getIdRangesAndIds(filename: String): Pair<ProductIdRange, MutableList<String>> {
            // Get input id ranges as a sorted linked list
            val url: URL = checkNotNull(Util::class.java.getResource(filename))
            val rootProductIdRange = ProductIdRange()
            val inputLines = mutableListOf<String>()

            url.openStream().bufferedReader().use { reader ->
                // Read id ranges
                while (true) {
                    val line = reader.readLine()
                    val bounds = line.split("-")
                    if (bounds.size != 2) {
                        break
                    }
                    val rangeToInsert = ProductIdRange()
                    rangeToInsert.lowerBound = bounds[0].toLong()
                    rangeToInsert.upperBound = bounds[1].toLong()

                    //Search position for range
                    var iterator = rootProductIdRange
                    var previousIterator: ProductIdRange? = null
                    while (true) {
                        // If iterator has higher bound, productId has to be placed ahead of this element in sorted list
                        if (iterator.lowerBound > rangeToInsert.lowerBound) {
                            previousIterator?.next = rangeToInsert
                            rangeToInsert.next = iterator
                            break
                        }

                        if (iterator.next == null) {
                            iterator.next = rangeToInsert
                            break
                        }
                        previousIterator = iterator
                        iterator = iterator.next!!
                    }
                }

                // Read ids to check
                while (true) {
                    val line = reader.readLine() ?: break
                    if (line.isBlank()) break
                    inputLines.add(line)
                }
            }

            return rootProductIdRange to inputLines
        }
    }
}