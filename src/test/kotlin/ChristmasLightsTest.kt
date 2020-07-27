import junit.framework.Assert.*
import org.junit.Test

class ChristmasLightsTest{

    @Test
    fun compileProject(){

    }

    @Test
    fun shouldStartWithZeroLightsOn() {
        val cl = ChristmasLights()

        val lightsOn = cl.countLightsOn()

        assertEquals(0, lightsOn)
    }

}
