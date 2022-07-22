fun main() {
    val line1 = readln().toInt()
    val line2 = readln().toInt()

    when (line1 * line2) {
        0 -> println("It can't be zero!")
        else -> println(line1 * line2)
    }
}