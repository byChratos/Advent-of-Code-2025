package de.cfe.helper

class Dial() {
    var endOnZero: Int = 0
    var loops: Int = 0
    private var location: Int = 50

    fun step(steps: Int, direction: Int) {
        for (i in 0..<steps) {
            // Rotate
            this.location += direction

            // Circle, depending on direction
            if (direction > 0 && this.location == 100) {
                this.location = 0
            } else if (direction < 0 && this.location == -1) {
                this.location = 99
            }

            // Click
            if (this.location == 0) {
                this.loops++
            }
        }

        // Ending rotation on a zero
        if (this.location == 0) {
            this.endOnZero++
            this.loops--
        }
    }

}