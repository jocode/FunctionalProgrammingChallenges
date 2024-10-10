package org.example.challenges;

import java.util.HashMap;
import java.util.Map;

public class Challenge2 {

    private static final Map<Character, String> leetMap = new HashMap<>();

    static {
        leetMap.put('a', "4");
        leetMap.put('b', "8");
        leetMap.put('c', "(");
        leetMap.put('d', "D");
        leetMap.put('e', "3");
        leetMap.put('f', "F");
        leetMap.put('g', "9");
        leetMap.put('h', "#");
        leetMap.put('i', "!");
        leetMap.put('j', ",_|");
        leetMap.put('k', ">|");
        leetMap.put('l', "1");
        leetMap.put('m', "/\\/\\");
        leetMap.put('n', "^/");
        leetMap.put('o', "0");
        leetMap.put('p', "9");
        leetMap.put('q', "(_,)");
        leetMap.put('r', "12");
        leetMap.put('s', "5");
        leetMap.put('t', "7");
        leetMap.put('u', "(_)");
        leetMap.put('v', "\\/");
        leetMap.put('w', "\\/\\/");
        leetMap.put('x', "><");
        leetMap.put('y', "Y");
        leetMap.put('z', "2");
        leetMap.put('0', "0");
        leetMap.put('1', "1");
        leetMap.put('2', "2");
        leetMap.put('3', "3");
        leetMap.put('4', "4");
        leetMap.put('5', "5");
        leetMap.put('6', "6");
        leetMap.put('7', "7");
        leetMap.put('8', "8");
        leetMap.put('9', "9");
    }

    /*
     * Write a program that receives a text and transforms natural language into
     * "hacker language" (actually known as "leet" or "1337"). This language
     * is characterized by replacing alphanumeric characters.
     * - Use this table (https://www.gamehouse.com/blog/leet-speak-cheat-sheet/)
     * with the alphabet and numbers in "leet".
     * (Use the first option of each transformation. For example "4" for "a")
     */
    public static String translateToLeet(String text) {
        StringBuilder translatedText = new StringBuilder();

        text.chars()
                .mapToObj(c -> (char) c) // Convert to Character
                .map(c -> leetMap.getOrDefault(Character.toLowerCase(c), String.valueOf(c))) // Translate to leet
                .forEach(translatedText::append); // Append to StringBuilder

        return translatedText.toString();
    }
}
