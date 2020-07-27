class ChristmasLights(private val width: Int, private val height: Int) {

    private var lightsOn = 0

    private var ligths : Array<Array<Boolean>> = Array(width) {
        Array(height) { false }
    }

    fun countLightsOn(): Int {
        return ligths.sumBy { it.count { j -> j }  }
    }

    fun turnOn(start: Pair<Int, Int>, finish: Pair<Int, Int>) {
        ligths[start.first][start.second] = true
    }
}
