package org.simonscode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04a {

    public static void main(String[] args) throws Exception {
        File input = new File("input/04");
        BufferedReader br = new BufferedReader(new FileReader(input));
        Pattern pattern = Pattern.compile("(\\d+)-(\\d+),(\\d+)-(\\d+)");
        int points = 0;

        while (br.ready()) {
            String line = br.readLine();
            Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()) {
                continue;
            }
            int[] numbers = {Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)),};

            if (numbers[0] == numbers[2] || numbers[1] == numbers[3]) {
                points++;
            } else if (numbers[0] < numbers[2]) {
                if (numbers[1] > numbers[3]) {
                    points++;
                }
            } else {
                if (numbers[3] > numbers[1]) {
                    points++;
                }
            }
        }

        System.out.println("Points: " + points);
    }
}
