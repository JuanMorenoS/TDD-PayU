class ChristmasLights(private val width: Int, private val height: Int) {
    private var lightsOn = 0
    fun countLightsOn(): Int {
        return lightsOn
    }

    fun turnOn(pair: Pair<Int, Int>, pair1: Pair<Int, Int>) {
        lightsOn++
    }

}
