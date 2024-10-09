package org.example.challenges

/*
 * Write a program that displays (with a print) the
 * numbers from 1 to 100 (both included, with a newline
 * between each print), replacing the following:
 * - Multiples of 3 with the word "fizz".
 * - Multiples of 5 with the word "buzz".
 * - Multiples of both 3 and 5 with the word "fizzbuzz".
 */
fun fizzbuzz(start: Int, end: Int) {
    (start..end).map { number ->
        when {
            number % 3 == 0 && number % 5 == 0 -> "fizzbuzz"
            number % 3 == 0 -> "fizz"
            number % 5 == 0 -> "buzz"
            else -> number
        }
    }.forEach { println(it) }
}