fun parseCardNumber(cardNumber: String): Long {
    // TODO
    try {
        if (!checkPartCount(cardNumber) || !validSpacesCount(cardNumber)) throw Exception()
        return cardNumber.replace(" ", "").toLong()
    } catch (e: NumberFormatException) {
        throw Exception()
    }
}

private fun checkPartCount(s: String): Boolean {
    val parsed = s.split(" ")
    if (parsed.size != 4) return false
    for (i in parsed) {
        if (i.length != 4) return false
    }
    return true
}

private fun validSpacesCount(s: String): Boolean {
    var count = 0
    for (i in s) {
        if (i == ' ') count++
    }
    return count == 3
}

//fun main() {
//    val input = readln()
//    println(parseCardNumber(input))
//}