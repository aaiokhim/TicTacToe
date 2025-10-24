fun main() {
    println("Enter condition of the field:")
    print("> ")

    val field = readln()
    if (field.length != 9 ) return

    showField(field)

    val xWin = checkFieldState(field, 'X')
    val oWin = checkFieldState(field, 'O')

    when {
        xWin && oWin -> println("Unreal situation")
        xWin -> println("X wins")
        oWin -> println("O wins")
        field.contains('_') -> println("The game continues")
        else -> println("Draw")
    }

}

fun checkFieldState(field : String, player : Char) : Boolean {
    for (i in 0..2) {
        if (field[i * 3] == player && field[i * 3 + 1] == player && field[i * 3 + 2] == player) {
            return true
        } else if (field[i] == player && field[i + 3] == player && field[i + 6] == player) {
            return true
        }
    }

    if (field[0] == player && field[4] == player && field[8] == player) {
        return true
    }

    if (field[2] == player && field[4] == player && field[6] == player) {
        return true
    }

    return false
}

fun showField(field : String) {
    val lowerLine = "-"
    val count = 9
    println(lowerLine.repeat(count))
    println("| ${field[0]} ${field[1]} ${field[2]} |")
    println("| ${field[3]} ${field[4]} ${field[5]} |")
    println("| ${field[6]} ${field[7]} ${field[8]} |")
    println(lowerLine.repeat(count))
}