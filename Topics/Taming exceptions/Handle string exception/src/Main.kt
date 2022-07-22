fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!
    try {
        println(word[index])
    } catch (e: StringIndexOutOfBoundsException) {
        println("There isn't such an element in the given string, please fix the index!")
    }

}