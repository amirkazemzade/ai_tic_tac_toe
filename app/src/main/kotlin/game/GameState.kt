package game

/** An enum class that has the all game states and their fitness function value.
 *
 *  @property value the value of fitness function for the game state.
 */
enum class GameState(val value: Int) {
    ONGOING(-2),
    WON(1),
    LOST(-1),
    TIED(0)
}