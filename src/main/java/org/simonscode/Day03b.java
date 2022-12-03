package org.simonscode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03b {

    public static void main(String[] args) throws Exception {
        File input = new File("input/03");
        BufferedReader br = new BufferedReader(new FileReader(input));
        int points = 0;

        while (br.ready()) {
            Set<Character> first = br.readLine()
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toSet());
            Set<Character> second = br.readLine()
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toSet());
            Set<Character> third = br.readLine()
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toSet());

            first.removeIf(c -> !second.contains(c));
            first.removeIf(c -> !third.contains(c));

            for (Character character : first) {
                points += charToPoints(character);
            }
        }

        System.out.println("Points: " + points);
    }

    static char upCaseBit = 'a' ^ 'A';

    private static int charToPoints(Character character) {
        char c = character;

        if ((c & upCaseBit) == 0) {
            return c - 'A' + 27;
        } else {
            return c - 'a' + 1;
        }
    }
}
