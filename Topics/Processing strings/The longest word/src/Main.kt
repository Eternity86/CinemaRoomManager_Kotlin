fun main() {
    // write your code here
    val input = readln().split(" ")
    var maxWord = 0
    var word = ""
    for (i in input.indices) {
        if (input[i].length > maxWord) {
            maxWord = input[i].length
            word = input[i]
        }
    }
    println(word)
}