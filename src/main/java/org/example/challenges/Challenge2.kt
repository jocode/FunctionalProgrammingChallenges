package org.example.challenges

/*
 * Write a program that receives a text and transforms natural language into
 * "hacker language" (actually known as "leet" or "1337"). This language
 * is characterized by replacing alphanumeric characters.
 * - Use this table (https://www.gamehouse.com/blog/leet-speak-cheat-sheet/)
 * with the alphabet and numbers in "leet".
 * (Use the first option of each transformation. For example "4" for "a")
 */
fun translateToLeetKt(text: String): String {
    val leetMap = mapOf(
        'a' to "4",
        'b' to "8",
        'c' to "(",
        'd' to "D",
        'e' to "3",
        'f' to "F",
        'g' to "9",
        'h' to "#",
        'i' to "!",
        'j' to ",_|",
        'k' to ">|",
        'l' to "1",
        'm' to "/\\/\\",
        'n' to "^/",
        'o' to "0",
        'p' to "9",
        'q' to "(_,)",
        'r' to "12",
        's' to "5",
        't' to "7",
        'u' to "(_)",
        'v' to "\\/",
        'w' to "\\/\\/",
        'x' to "><",
        'y' to "Y",
        'z' to "2",
        '0' to "0",
        '1' to "1",
        '2' to "2",
        '3' to "3",
        '4' to "4",
        '5' to "5",
        '6' to "6",
        '7' to "7",
        '8' to "8",
        '9' to "9"
    )

    return text.toCharArray()
        .joinToString("") { leetMap[it.lowercaseChar()] ?: it.toString() }
}