package game

/**
 * an enum that has the possible shapes of a cell in the game
 */
enum class Shape { CROSS, CIRCLE, NONE }

/**
 * an extension function for [Shape] that prints the shape
 */
fun Shape.draw() = print(this.getChar())

/**
 * an extension function for [Shape] that returns the char of the shape
 */
fun Shape.getChar(): Char = when (this) {
    Shape.CROSS -> 'X'
    Shape.CIRCLE -> 'O'
    else -> ' '
}