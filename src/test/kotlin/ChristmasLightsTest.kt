import junit.framework.Assert.*
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
        assertEquals(1, counter)
    }

    @Test
    fun `lightsOn should be 2 if the coordinates range have 2 lights to be turned on`() {

        val cl = buildLights()
        cl.turnOn((0 to 0), (0 to 1))
        val lightsOnCount = cl.countLightsOn();
        assertEquals(2, lightsOnCount);
    }

    @Test
    fun `lights should be off when calling turnOff method`(){
        val lights = buildLights()
        lights.turnOn((0 to 0), (0 to 1))
        lights.turnOff((0 to 0), (0 to 1))
        assertEquals(0, lights.countLightsOn())
    }

    private fun buildLights() = ChristmasLights(1000, 1000)
}
