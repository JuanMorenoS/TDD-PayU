class ChristmasLights(private val width: Int, private val height: Int) {

    class BadInputException : RuntimeException()

    private var lights: Array<Array<Int>> = Array(width) {
        Array(height) { 0 }
    }

    fun countLightsOn(): Int {
        return lights.sumBy { it.sumBy { j -> j } }
    }

    fun turnOn(start: Pair<Int, Int>, finish: Pair<Int, Int>) {
        changeState(start, finish) { it + 1 }
    }

    private fun validateInput(start: Pair<Int, Int>, finish: Pair<Int, Int>) {
        if (isOutOfRange(start) || isOutOfRange(finish) || isInvalidRectangle(start, finish)) {
            throw BadInputException()
        }
    }

    private fun isInvalidRectangle(
        start: Pair<Int, Int>,
        finish: Pair<Int, Int>
    ) = start.first > finish.first || start.second > finish.second

    private fun isOutOfRange(start: Pair<Int, Int>): Boolean {
        return start.first < 0 || start.first >= width || start.second < 0 || start.second >= height
    }

    fun turnOff(start: Pair<Int, Int>, finish: Pair<Int, Int>) {
        changeState(start, finish) { if (it > 0) it - 1 else 0 }
    }

    fun toggle(start: Pair<Int, Int>, finish: Pair<Int, Int>) {
        changeState(start, finish) { it + 2 }
    }

    private fun changeState(
        start: Pair<Int, Int>,
        finish: Pair<Int, Int>,
        stateFunction: ((Int) -> Int)
    ) {
        validateInput(start, finish)
        executeChangeState(start, finish, stateFunction)
    }

    private fun executeChangeState(
        start: Pair<Int, Int>,
        finish: Pair<Int, Int>,
        stateFunction: (Int) -> Int
    ) {
        val rows = start.first..finish.first
        val columns = start.second..finish.second

        rows.forEach { row ->
            columns.forEach { column ->
                lights[row][column] = stateFunction(lights[row][column])
            }
        }
    }
}


