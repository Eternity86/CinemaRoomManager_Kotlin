fun main() {
    // write your code here
    val s = readln()
    var res = true
    for (i in 0..s.length - 2) {
        if (s[i] + 1 == s[i + 1]) continue else res = false
    }
    println(res)
}