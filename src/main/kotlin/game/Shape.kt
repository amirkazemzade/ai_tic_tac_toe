package game

enum class Shape { CROSS, CIRCLE, NONE }

class ShapeDrawer {
    companion object {
        fun draw(shape: Shape) = print(getChar(shape))

        fun getChar(shape: Shape): Char = when (shape) {
            Shape.CROSS -> 'X'
            Shape.CIRCLE -> 'O'
            else -> ' '
        }
    }
}