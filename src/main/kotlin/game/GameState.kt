package game

enum class GameState(val value: Int) {
    ONGOING(-2),
    WON(1),
    LOST(-1),
    TIED(0)
}