import java.util.Scanner
val scan = Scanner(System.`in`)

fun main() {
    // write your code here
    val s = scan.next()
    val n = scan.nextInt()
    println(if (n > s.length) s else s.substring(n) + s.substring(0, n))
}