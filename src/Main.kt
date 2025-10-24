fun main() {
    println("Enter condition of the field:")
    print("> ")

    val field = readln()
    val lowerLine = "-"
    val count = 9
    println(lowerLine.repeat(count))
    println("| ${field[0]} ${field[1]} ${field[2]} |")
    println("| ${field[3]} ${field[4]} ${field[5]} |")
    println("| ${field[6]} ${field[7]} ${field[8]} |")
    println(lowerLine.repeat(count))
}