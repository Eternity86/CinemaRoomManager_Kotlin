const val VOWELS = "aeiouy"
const val LIMIT = 3

fun main() {
    // write your code here
    val input = readln()
    var vowelCount = 0
    var consonantCount = 0
    var count = 0
    for (ch in input) {
        if (ch in VOWELS) {
            vowelCount++
            consonantCount = 0
            if (vowelCount == LIMIT) {
                count++
                vowelCount = 1
            }
        } else {
            consonantCount++
            vowelCount = 0
            if (consonantCount == LIMIT) {
                count++
                consonantCount = 1
            }
        }
    }
    println(count)
}