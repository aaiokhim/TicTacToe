fun main() {
    val field = MutableList(9) { '_' }
    showField(field)

    var state: Boolean = true
    var count = 0

    while (state) {
        if (count % 2 == 0) {
            println("Player X, please make a move")
            move(field, count)
        } else {
            println("Player O, please make a move")
            move(field, count)
        }

        showField(field)
        state = stateGame(field)
        count += 1
    }
}

fun move(field : MutableList<Char>, count : Int) {
    println("Please enter coordinates separated by spaces.")
    print("> ")

    val newCoordinate = getCoordinates(field)

    if (count % 2 == 0){
        field[newCoordinate] = 'X'
    } else {
        field[newCoordinate] = 'O'
    }
}

fun getCoordinates(field : MutableList<Char>) : Int {
    var state = true
    var newCoordinate = -1
    do {
        val coordinates = readln().split(" ")
        if (coordinates.size != 2) {
            println("Incorrect data entry, try again \n> ")
            continue
        }
        val x = coordinates[0].toIntOrNull()
        val y = coordinates[1].toIntOrNull()

        if (x == null || y == null || x !in 0..8 || y !in 0..8) {
            println("Incorrect data entry, try again \n> ")
            continue
        }

        newCoordinate = (x - 1) * 3 + (y - 1)

        if (field[newCoordinate] != '_') {
            println("Incorrect data entry, try again")
            print("> ")
            continue
        } else {
            state = false
        }

    } while (state)

    return newCoordinate
}

fun stateGame(field : MutableList<Char>) : Boolean {
    val xWin = checkFieldState(field, 'X')
    val oWin = checkFieldState(field, 'O')

    when {
        xWin && oWin -> {
            println("Unreal situation")
            return false
        }
        xWin -> {
            println("X wins")
            return false
        }
        oWin -> {
            println("O wins")
            return false
        }
        field.contains('_') -> {
            println("The game continues")
            return true
        }
        else -> {
            println("Draw")
            return false
        }
    }
}

fun checkFieldState(field : MutableList<Char>, player : Char) : Boolean {
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

fun showField(field : MutableList<Char>) {
    val lowerLine = "-"
    val count = 9
    println(lowerLine.repeat(count))
    println("| ${field[0]} ${field[1]} ${field[2]} |")
    println("| ${field[3]} ${field[4]} ${field[5]} |")
    println("| ${field[6]} ${field[7]} ${field[8]} |")
    println(lowerLine.repeat(count))
}