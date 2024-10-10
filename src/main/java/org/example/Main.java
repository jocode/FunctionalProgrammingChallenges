package org.example;


import static org.example.challenges.Challenge2.translateToLeet;
import static org.example.challenges.Challenge2Kt.translateToLeetKt;

public class Main {
    public static void main(String[] args) {
        String translation = translateToLeet("Hola mundo vagabundo");
        String translationKt = translateToLeetKt("Hola mundo vagabundo");
        System.out.println(translation);
        System.out.println(translationKt);
    }
}