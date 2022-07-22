fun calculateBrakingDistance(v1: String, a: String): Int {
    // write your code here
    return try {
        (0 * 0 - v1.toInt() * v1.toInt()) / (2 * a.toInt())
    } catch (e: NumberFormatException) {
        println(e.message)
        -1
    } catch (e: ArithmeticException) {
        println("The car does not slow down!")
        -1
    }
}
