package org.example;


import java.util.List;

import static org.example.challenges.Challenge3.playTennis;
import static org.example.challenges.Challenge3Kt.playTennisKt;

public class Main {
    public static void main(String[] args) {
        List<String> sequence = List.of("P1", "P1", "P2", "P2", "P1", "P2", "P1", "P1");
        playTennis(sequence);
        System.out.println('\n');
        playTennisKt(sequence);
    }
}