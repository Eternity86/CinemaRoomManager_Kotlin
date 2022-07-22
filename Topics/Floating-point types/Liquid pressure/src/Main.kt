const val G = 9.8

fun main() {
    // write your code here
    val (d, h) = List(2) { readln().toDouble() }
    println(d * G * h)
}