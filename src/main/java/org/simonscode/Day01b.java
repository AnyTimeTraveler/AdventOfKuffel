package org.simonscode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class Day01b {
    public static void main(String[] args) throws IOException {

        File input = new File("input/01");

        BufferedReader br = new BufferedReader(new FileReader(input));

        ArrayList<Integer> calories =new ArrayList<>();

        int current = 0;
        while (br.ready()) {
            String line = br.readLine();

            if (line.isBlank()) {
                calories.add(current);
                current = 0;
            } else {
                current += Integer.parseInt(line);
            }
        }

        calories.sort((a,b) -> b-a);

        System.out.println(calories.get(0));
        System.out.println(calories.get(1));
        System.out.println(calories.get(2));

        System.out.println(calories.get(0) + calories.get(1) + calories.get(2));
    }
}
