import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail
import org.junit.Test

class ChristmasLightsTest {

    @Test
    fun shouldStartWithZeroLightsOn() {
        val cl = buildLights()

        val lightsOn = cl.countLightsOn()

        assertEquals(0, lightsOn)
    }

    @Test
    fun `One light is on when range is one point`() {
        val cl = buildLights()
        cl.turnOn((0 to 0), (0 to 0))
        val counter = cl.countLightsOn()
        assertEquals(1, counter)
    }

    @Test
    fun `One light is on when turning on the same point`() {
        val cl = buildLights()
        cl.turnOn((0 to 0), (0 to 0))
        cl.turnOn((0 to 0), (0 to 0))
        val counter = cl.countLightsOn()
        assertEquals(2, counter)
    }

    @Test
    fun `lightsOn should be 2 if the coordinates range have 2 lights to be turned on`() {

        val cl = buildLights()
        cl.turnOn((0 to 0), (0 to 1))
        val lightsOnCount = cl.countLightsOn();
        assertEquals(2, lightsOnCount);
    }

    @Test
    fun `lights should be off when calling turnOff method`() {
        val lights = buildLights()
        lights.turnOn((0 to 0), (0 to 1))
        lights.turnOff((0 to 0), (0 to 1))
        assertEquals(0, lights.countLightsOn())
    }

    @Test
    fun `intersection should be off after turnOff`() {

        val lights = buildLights()
        lights.turnOn((1 to 1), (100 to 100))
        lights.turnOff((1 to 1), (50 to 100))
        assertEquals(5000, lights.countLightsOn())
    }

    @Test
    fun `toggle should invert the light state`() {
        val lights = buildLights()
        lights.turnOn((101 to 101), (300 to 300)) // 200x200
        lights.toggle((201 to 201), (400 to 400)) // (200x200-100x100) + (3x100x100) == 60_000
        assertEquals(120_000, lights.countLightsOn())
    }

    @Test
    fun `turn off light with brightness 0 should not change brightness`() {
        val lights = buildLights()
        lights.turnOff((0 to 0), (100 to 100))
        assertEquals(0, lights.countLightsOn())
    }

    @Test
    fun `should be 0 when we turn off two times after toggle`() {
        val lights = buildLights()
        lights.toggle((0 to 0), (999 to 999))
        lights.turnOff((0 to 0), (999 to 999))
        lights.turnOff((0 to 0), (999 to 999))
        assertEquals(0, lights.countLightsOn())
    }

    @Test(expected = ChristmasLights.BadInputException::class)
    fun `should return an exception when the range is bad`() {
        val lights = buildLights()
        lights.turnOn((800 to 800), (1000 to 1000))
    }

    @Test
    fun `should not turn on a light when an exception was throw`() {
        val lights = buildLights()
        try {
            lights.turnOn((800 to 800), (1000 to 1000))
            fail()
        }catch (exception: ChristmasLights.BadInputException){
        }
        assertEquals(0, lights.countLightsOn())
    }

    private fun buildLights() = ChristmasLights(1000, 1000)
}
