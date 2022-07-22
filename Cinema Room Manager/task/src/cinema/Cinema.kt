package cinema

import java.util.Locale

const val REGULAR_TICKET_PRICE = 10
const val REDUCED_TICKET_PRICE = 8
const val REGULAR_SEATS_LIMIT = 60
const val S_SIGN = 'S'
const val B_SIGN = 'B'

var currentIncome: Int = 0

fun main() {
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()
    println()

    val cinema = Array(rows) { Array(seats) { S_SIGN } }

    while (true) {
        showMenu()
        when (readln().toInt()) {
            1 -> showSeats(cinema)
            2 -> buyTicket(cinema)
            3 -> getStatistic(cinema)
            0 -> return
        }
    }
}

private fun showSeats(cinema: Array<Array<Char>>) {
    println("Cinema: ")
    for (i in 0..cinema[0].size) {
        if (i == 0) print(" ") else print(" $i")
    }
    println()
    for (i in cinema.indices) {
        print(i + 1)
        for (j in cinema[i].indices) {
            print(" ${cinema[i][j]}")
        }
        println()
    }
    println()
}

private fun buyTicket(cinema: Array<Array<Char>>) {
    var state = false
    var rowNumber: Int
    var seatNumber: Int
    loop@while (!state) {
        println("Enter a row number:")
        rowNumber = readln().toInt()
        println("Enter a seat number in that row:")
        seatNumber = readln().toInt()
        if (rowNumber > cinema.size || seatNumber > cinema[0].size) {
            println("Wrong input!\n")
            continue@loop
        }
        if (cinema[rowNumber - 1][seatNumber - 1] == B_SIGN) {
            println("That ticket has already been purchased!\n")
            continue@loop
        }
        if (cinema.size * cinema[0].size <= REGULAR_SEATS_LIMIT) {
            println("Ticket price: $$REGULAR_TICKET_PRICE\n")
            currentIncome += REGULAR_TICKET_PRICE
        } else {
            if (rowNumber >= (cinema.size - cinema.size / 2)) {
                println("Ticket price: $$REDUCED_TICKET_PRICE\n")
                currentIncome += REDUCED_TICKET_PRICE
            } else {
                println("Ticket price: $$REGULAR_TICKET_PRICE\n")
                currentIncome += REGULAR_TICKET_PRICE
            }
        }
        cinema[rowNumber - 1][seatNumber - 1] = B_SIGN
        state = true
    }
}

private fun getStatistic(cinema: Array<Array<Char>>) {
    val rows = cinema.size
    val seats = cinema[0].size
    var seatCount = 0
    for (row in cinema) {
        for (seat in row) {
            if (seat == B_SIGN) seatCount++
        }
    }
    val percentage = (seatCount / (rows * seats).toFloat()) * 100
    val formatPercentage = "%.2f".format(percentage, Locale.US)
    println("Number of purchased tickets: $seatCount")
    println("Percentage: $formatPercentage%")
    println("Current income: $$currentIncome")
    println("Total income: $${getTotalIncome(cinema)}")
    println()
}

private fun showMenu() {
    println(
        """
        1. Show the seats
        2. Buy a ticket
        3. Statistics
        0. Exit
    """.trimIndent()
    )
}

private fun getTotalIncome(cinema: Array<Array<Char>>): Int {
    val rows = cinema.size
    val seats = cinema[0].size
    return if (rows * seats <= REGULAR_SEATS_LIMIT) {
        rows * seats * REGULAR_TICKET_PRICE
    } else {
        val frontHalfSeats = rows / 2 * seats * 10
        val backHalfSeats = (rows - rows / 2) * seats * 8
        frontHalfSeats + backHalfSeats
    }
}