import game.Shape
import game.getChar
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShapeDrawerTest {

    @Test
    fun testDrawCross() {
        val expected = 'X'
        assertEquals(expected, Shape.CROSS.getChar())
    }

    @Test
    fun testDrawCircle() {
        val expected = 'O'
        assertEquals(expected, Shape.CIRCLE.getChar())
    }

    @Test
    fun testDrawNone() {
        val expected = ' '
        assertEquals(expected, Shape.NONE.getChar())
    }
}