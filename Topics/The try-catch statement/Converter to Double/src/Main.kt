fun convertStringToDouble(input: String): Double {
    /**
     * It returns a double value or 0 if an exception occurred
     */
    return try {
        input.toDouble()
    } catch (e: java.lang.Exception) {
        0.0
    }
}