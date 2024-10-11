package org.example.challenges;

import java.util.Arrays;
import java.util.List;

public class Challenge3 {

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
    public static void playTennis(List<String> sequence) {
        List<String> scoreNames = Arrays.asList("Love", "15", "30", "40");

        // Initial scores
        Score initialScore = new Score(0, 0);

        sequence.stream().reduce(initialScore, (score, point) -> {
                Score newScore = updateScore(score, point);

                displayGameStatus(newScore.p1Score, newScore.p2Score, scoreNames);

                return newScore;
            }, (score1, score2) -> score1 // Combiner is not needed here
        );
    }

    static Score updateScore(Score score, String point) {
        return switch (point) {
            case "P1" -> new Score(score.p1Score + 1, score.p2Score);
            case "P2" -> new Score(score.p1Score, score.p2Score + 1);
            default -> {
                System.out.println("Invalid input: " + point);
                yield score;
            }
        };
    }

    public static void displayGameStatus(int newScoreP1, int newScoreP2, List<String> scoreNames) {
        if (hasWinner(newScoreP1, newScoreP2)) {
            System.out.println("Ha ganado el " + (newScoreP1 > newScoreP2 ? "P1" : "P2"));
        } else if (hasAdvantage(newScoreP1, newScoreP2)) {
            System.out.println("Ventaja " + (newScoreP1 > newScoreP2 ? "P1" : "P2"));
        } else if (isDeuce(newScoreP1, newScoreP2)) {
            System.out.println("Deuce");
        } else {
            String p1Score = newScoreP1 < scoreNames.size() ? scoreNames.get(newScoreP1) : "40";
            String p2Score = newScoreP2 < scoreNames.size() ? scoreNames.get(newScoreP2) : "40";
            System.out.println(p1Score + " - " + p2Score);
        }
    }

    public static boolean hasWinner(int p1Score, int p2Score) {
        return (p1Score >= 4 || p2Score >= 4) && Math.abs(p1Score - p2Score) >= 2;
    }

    public static boolean hasAdvantage(int p1Score, int p2Score) {
        return (p1Score > 3 || p2Score > 3) && Math.abs(p1Score - p2Score) == 1;
    }

    public static boolean isDeuce(int p1Score, int p2Score) {
        return p1Score >= 3 && p1Score == p2Score;
    }

    static class Score {
        int p1Score;
        int p2Score;

        Score(int p1Score, int p2Score) {
            this.p1Score = p1Score;
            this.p2Score = p2Score;
        }
    }
}