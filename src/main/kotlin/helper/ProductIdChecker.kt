package de.cfe.helper

class ProductIdChecker {
    companion object {
        private fun isInvalidPart1(id: Long?): Boolean {
            val idString = id.toString()

            // Odd sized numbers cant have repeated patterns
            if (idString.length % 2 != 0) {
                return false
            }

            val leftSplit = idString.substring(0, idString.length / 2)
            val rightSplit = idString.substring(idString.length / 2)
            return leftSplit == rightSplit
        }

        private fun isInvalidPart2(id: Long?): Boolean {
            val idString = id.toString()
            val length = idString.length

            for (lenOfPattern in 1..<length) {
                // Cant be a repeated pattern, as no multiple of pattern length is the correct length

                if (length % lenOfPattern != 0) continue
                val pattern = idString.substring(0, lenOfPattern)

                // Number if pattern is repeated to fit length of id
                val repeatedPattern = pattern.repeat(length / lenOfPattern)
                if (repeatedPattern == idString) {
                    return true
                }
            }

            return false
        }

        fun checkRange(lower: String, upper: String, part: Int): MutableList<Long?> {
            val invalidIds: MutableList<Long?> = java.util.ArrayList<Long?>()

            for (i in lower.toLong()..upper.toLong()) {
                if (part == 1 && isInvalidPart1(i)) {
                    invalidIds.add(i)
                } else if (part == 2 && isInvalidPart2(i)) {
                    invalidIds.add(i)
                }
            }
            return invalidIds
        }
    }
}