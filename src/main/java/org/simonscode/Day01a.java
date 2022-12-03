package org.simonscode;

import java.io.*;

public class Day01a {
    public static void main(String[] args) throws IOException {

        File input = new File("input/01");

        BufferedReader br = new BufferedReader(new FileReader(input));

        int current = 0, highest = 0;

        while (br.ready()) {
            String line = br.readLine();

            if (line.isBlank()) {
                if (current > highest) {
                    highest = current;
                }
                current = 0;
            } else {
                current += Integer.parseInt(line);
            }
        }

        System.out.println("Highest: " + highest);
    }
}
