package org.example.challenges

/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */
fun main() {
    val fibonacciSequence = generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }
        .take(50)
        .map { it.first }
        .toList()

    println(fibonacciSequence)
}
