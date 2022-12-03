package org.simonscode;

import java.io.*;

public class Day02a {
    enum Shape {
        ROCK(1),
        PAPER(2),
        SCISSORS(3);

        private final int value;

        Shape(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public boolean winAgainst(Shape opponent) {
            return this == SCISSORS && opponent == PAPER ||
                    this == PAPER && opponent == ROCK ||
                    this == ROCK && opponent == SCISSORS;
        }
    }

    public static Shape charToShape(char c) {
        return switch (c) {
            case 'A', 'X' -> Shape.ROCK;
            case 'B', 'Y' -> Shape.PAPER;
            case 'C', 'Z' -> Shape.SCISSORS;
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
            Shape i = charToShape(chars[2]);

            points += i.getValue();

            if (i == opponent) {
                points += 3;
            } else if (i.winAgainst(opponent)) {
                points += 6;
            }
        }

        System.out.println("Points: " + points);
    }
}
