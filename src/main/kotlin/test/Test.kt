import game.Shape
import game.ShapeDrawer

fun main() {
    testShapeDrawer()
}

fun testShapeDrawer(){
    ShapeDrawer.draw(Shape.NONE)
    println()
    ShapeDrawer.draw(Shape.CIRCLE)
    println()
    ShapeDrawer.draw(Shape.CROSS)
    println()
}