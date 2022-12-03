package org.simonscode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.simonscode.Day02b.Shape.*;

public class Day02b {
    enum Shape {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);
        private final int value;
        Shape(int value) {
            this.value = value;
        }
    }
    enum Outcome {
        WIN(6),
        LOSE(0),
        DRAW(3);
        private final int value;
        Outcome(int value) {
            this.value = value;
        }
    }

    public static Shape charToShape(char c) {
        return switch (c) {
            case 'A' -> Shape.ROCK;
            case 'B' -> PAPER;
            case 'C' -> Shape.SCISSORS;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }
    public static Outcome charToOutcome(char c) {
        return switch (c) {
            case 'X' -> Outcome.LOSE;
            case 'Y' -> Outcome.DRAW;
            case 'Z' -> Outcome.WIN;
            default -> throw new IllegalStateException("Unexpected value: " + c);
        };
    }

    public static void main(String[] args) throws IOException {
        File input = new File("input/02");

        BufferedReader br = new BufferedReader(new FileReader(input));

        int points = 0;

        while (br.ready()) {
            String line = br.readLine();

            char[] chars = line.toCharArray();

            Shape opponent = charToShape(chars[0]);
            Outcome outcome = charToOutcome(chars[2]);

            Shape i = getMe(opponent, outcome);

            points += outcome.value;
            points += i.value;
        }

        System.out.println("Points: " + points);
    }

    private static Shape getMe(Shape opponent, Outcome outcome) {
        switch (outcome) {
            case WIN -> {
                return switch (opponent) {
                    case ROCK -> PAPER;
                    case PAPER -> SCISSORS;
                    case SCISSORS -> ROCK;
                };
            }
            case LOSE -> {
                return switch (opponent){
                    case ROCK -> SCISSORS;
                    case PAPER -> ROCK;
                    case SCISSORS -> PAPER;
                };
            }
            case DRAW -> {
                return opponent;
            }
            default -> throw new IllegalStateException("Unexpected value: " + outcome +" : "+ opponent);
        }
    }
}
