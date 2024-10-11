package org.example.challenges

import kotlin.math.abs

/*
* Write a program that shows how a tennis game goes and who won it.
* The program will receive a sequence consisting of "P1" (Player 1) or "P2" (Player 2), depending on who
* win every point of the game.
*
* - The scores of a game are "Love" (zero), 15, 30, 40, "Deuce" (tie), advantage.
* - Given the sequence [P1, P1, P2, P2, P1, P2, P1, P1], the program would display the following:
* 15 - Love
* 30 - Love
* 30 - 15
* 30 - 30
* 40 - 30
* Deuce
* P1 advantage
* He has won P1
* - If you want, you can control errors in data entry.
* - Consult the game rules if you have questions about the points system.
*/
fun playTennisKt(sequence: List<String>) {
    val scoreNames = listOf("Love", "15", "30", "40")

    sequence.fold(0 to 0) { (scoreP1, scoreP2), point ->
        val (newScoreP1, newScoreP2) = when (point) {
            "P1" -> (scoreP1 + 1) to scoreP2
            "P2" -> scoreP1 to (scoreP2 + 1)
            else -> {
                println("Entrada inválida: $point")
                scoreP1 to scoreP2
            }
        }

        // Show the game status
        displayGameStatus(newScoreP1, newScoreP2, scoreNames)

        newScoreP1 to newScoreP2
    }
}

fun displayGameStatus(newScoreP1: Int, newScoreP2: Int, scoreNames: List<String>) {
    when {
        hasWinner(newScoreP1, newScoreP2) -> {
            println("Ha ganado el ${if (newScoreP1 > newScoreP2) "P1" else "P2"}")
        }
        hasAdvantage(newScoreP1, newScoreP2) -> {
            println("Ventaja ${if (newScoreP1 > newScoreP2) "P1" else "P2"}")
        }
        isDeuce(newScoreP1, newScoreP2) -> {
            println("Deuce")
        }
        else -> {
            val p1Score = scoreNames.getOrNull(newScoreP1) ?: "40"
            val p2Score = scoreNames.getOrNull(newScoreP2) ?: "40"
            println("$p1Score - $p2Score")
        }
    }
}

fun hasWinner(p1Score: Int, p2Score: Int): Boolean {
    return (p1Score >= 4 || p2Score >= 4) && abs(p1Score - p2Score) >= 2
}

fun hasAdvantage(p1Score: Int, p2Score: Int): Boolean {
    return (p1Score > 3 || p2Score > 3) && abs(p1Score - p2Score) == 1
}

fun isDeuce(p1Score: Int, p2Score: Int): Boolean {
    return p1Score >= 3 && p1Score == p2Score
}