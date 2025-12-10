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
    }
}