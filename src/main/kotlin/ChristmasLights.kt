class ChristmasLights(private val width: Int, private val height: Int) {

    private var lights: Array<Array<Boolean>> = Array(width) {
        Array(height) { false }
    }

    fun countLightsOn(): Int {
        return lights.sumBy { it.count { j -> j } }
    }

    fun turnOn(start: Pair<Int, Int>, finish: Pair<Int, Int>) {

        val row = start.first..finish.first
        val column = start.second..finish.second

        row.forEach { x ->
            column.forEach { y ->
                lights[x][y] = true
            }
        }
    }
}
