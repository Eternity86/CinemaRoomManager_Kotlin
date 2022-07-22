fun main() {
    // write your code here
    println(if (checkTicket(readln())) "Lucky" else "Regular")
}

fun checkTicket(s: String): Boolean {
    if (s.length < 6) return false
    return (s[0].code + s[1].code + s[2].code == s[3].code + s[4].code + s[5].code)
}