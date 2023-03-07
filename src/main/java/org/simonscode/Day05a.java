package org.simonscode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05a {

    public static void main(String[] args) throws Exception {
        File input = new File("input/05");
        BufferedReader br = new BufferedReader(new FileReader(input));
        int points = 0;

        char[][] initialState = new char[9][8];

        List<Stack<Character>> stacks = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            stacks.add(new Stack<>());
        }

        int lineNumber = 1;
        while (br.ready()) {
            String line = br.readLine();
            if (lineNumber < 9) {
                char[] chars = line.toCharArray();
                for (int letter = 1, column = 0; letter < chars.length; letter += 3, column++) {
                    initialState[column][lineNumber - 1] = chars[letter];
                }
            }
            lineNumber++;
            if (lineNumber == 9) {
                convertCharsToStacks(initialState, stacks);
            }
        }

        System.out.println("Points: " + points);
    }

    private static void convertCharsToStacks(char[][] initialState, List<Stack<Character>> stacks) {
        for (int i = 0; i < initialState.length; i++) {
            for (int j = 0; j < initialState[0].length; j++) {
                stacks.get(i).push(initialState[i][j]);
            }
        }
        for (Stack<Character> stack : stacks) {
            System.out.println(stack);
        }
    }
}
