class ChristmasLights(private val width: Int, private val height: Int) {

    private var lights: Array<Array<Boolean>> = Array(width) {
        Array(height) { false }
    }

    fun countLightsOn(): Int {
        return lights.sumBy { it.count { j -> j } }
    }

    fun turnOn(start: Pair<Int, Int>, finish: Pair<Int, Int>) {

        changeState(start, finish, true)
    }

    fun turnOff(start: Pair<Int, Int>, finish: Pair<Int, Int>) {
        changeState(start, finish, false)
    }

    private fun changeState(
        start: Pair<Int, Int>,
        finish: Pair<Int, Int>,
        state: Boolean
    ) {
        val rows = start.first..finish.first
        val columns = start.second..finish.second

        rows.forEach { row ->
            columns.forEach { column ->
                lights[row][column] = state
            }
        }
    }
}
