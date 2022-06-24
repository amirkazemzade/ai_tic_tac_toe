import game.Shape
import game.ShapeDrawer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ShapeDrawerTest {

    @Test
    fun testDrawCross() {
        val expected = 'X'
        assertEquals(expected, ShapeDrawer.getChar(Shape.CROSS))
    }

    @Test
    fun testDrawCircle() {
        val expected = 'O'
        assertEquals(expected, ShapeDrawer.getChar(Shape.CIRCLE))
    }

    @Test
    fun testDrawNone() {
        val expected = ' '
        assertEquals(expected, ShapeDrawer.getChar(Shape.NONE))
    }
}