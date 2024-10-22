package org.example.challenges;

import java.util.List;
import java.util.stream.Stream;

/*
 * Escribe un programa que imprima los 50 primeros números de la sucesión
 * de Fibonacci empezando en 0.
 * - La serie Fibonacci se compone por una sucesión de números en
 *   la que el siguiente siempre es la suma de los dos anteriores.
 *   0, 1, 1, 2, 3, 5, 8, 13...
 */
class Challenge4 {
    public static void main(String[] args) {
        List<Integer> fibonacci = Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(50)
                .map(n -> n[0])
                .toList();

        System.out.println(fibonacci);
    }
}