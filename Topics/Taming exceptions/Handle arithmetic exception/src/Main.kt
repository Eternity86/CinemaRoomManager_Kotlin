fun main() {
    // put your code here
    val in1 = readln().toInt()
    val in2 = readln().toInt()
    try {
        println(in1 / in2)
    } catch (e: ArithmeticException) {
        println("Division by zero, please fix the second argument!")
    }
}