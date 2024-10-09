package org.example.challenges;

import java.util.stream.IntStream;

public class Challenge1 {
    /*
     * Write a program that displays (with a print) the
     * numbers from 1 to 100 (both included, with a newline
     * between each print), replacing the following:
     * - Multiples of 3 with the word "fizz".
     * - Multiples of 5 with the word "buzz".
     * - Multiples of both 3 and 5 with the word "fizzbuzz".
     */
    public static void fizzbuzz(int start, int end) {
        IntStream.rangeClosed(start, end)
                .mapToObj(i -> {
                    if (i % 3 == 0 && i % 5 == 0) {
                        return "fizzbuzz";
                    } else if (i % 3 == 0) {
                        return "fizz";
                    } else if (i % 5 == 0) {
                        return "buzz";
                    } else {
                        return String.valueOf(i);
                    }
                })
                .forEach(System.out::println);
    }
}
