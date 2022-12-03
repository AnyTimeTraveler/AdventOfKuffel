package org.simonscode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03a {

    public static void main(String[] args) throws IOException {
        File input = new File("input/03");
        BufferedReader br = new BufferedReader(new FileReader(input));
        int points = 0;

        while (br.ready()) {
            String line = br.readLine();
            Set<Character> left = line.substring(0, line.length() / 2)
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toSet());
            Set<Character> right = line.substring(line.length() / 2)
                    .chars()
                    .mapToObj(c -> (char) c)
                    .collect(Collectors.toSet());

            left.removeIf(c -> !right.contains(c));

            for (Character character : left) {
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
