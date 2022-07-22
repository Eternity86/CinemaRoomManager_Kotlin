fun main() {
    // write your code here
    val url = readln()
    val params = url.split("?")[1]
    val param = params.split("&")
    var hasPass = false
    var password: String? = null
    for (i in param) {
        val key = i.split("=")[0]
        var value = i.split("=")[1]
        if (value.isEmpty()) value = "not found"
        if (key == "pass") {
            hasPass = true
            password = value
        }
        println("$key : $value")
    }
    if (hasPass) println("password : $password")
}