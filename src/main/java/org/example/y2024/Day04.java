
package org.example.y2024;

import org.example.framework.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day04 extends Day {

    private List<String> input;
    private String[][] baseMatrix; // hardcoded to 140, due to main task.
    private int matrixDimentions = 0;

    private static final String CLEARED = ".";

    @Override
    public void parseInput() {
        input = getInput();

        matrixDimentions = input.size();
        baseMatrix = new String[matrixDimentions][matrixDimentions];
        for (int i = 0, inputSize = input.size(); i < inputSize; i++) {
            String row = input.get(i);
            String[] split = row.split("");
            for (int k = 0; k < split.length; k++) {
                baseMatrix[i][k] = split[k];
            }
        }
    }

    @Override
    public String evalPart1() {
        // Count vertical
        Pattern xmas = Pattern.compile("XMAS");
        Pattern samx = Pattern.compile("SAMX");
        int counter = countPatternNormalString(input, xmas, samx);
        // Count horizontal
        List<String> flipped = flipInput();
        counter += countPatternNormalString(flipped, xmas, samx);

        // Count diagonally

        return null;
    }

    private List<String> flipInput() {
        List<StringBuilder> temp = new ArrayList<>();
        // Initialize StringBuilders for flipped strings
        for (int i = 0; i < input.size(); i++) {
            temp.add(new StringBuilder());
        }

        // Populate the StringBuilders with characters from each string in input
        for (String str : input) {
            for (int i = 0; i < str.length(); i++) {
                temp.get(i).append(str.charAt(i));
            }
        }
        List<String> flipped = new ArrayList<>();
        for (StringBuilder sb : temp) {
            flipped.add(sb.toString());
        }
        return flipped;
    }

    private int countPatternNormalString(List<String> input, Pattern xmas, Pattern samx) {
        int counter = 0;
        for (String row : input) {
            Matcher matcher1 = xmas.matcher(row);
            Matcher matcher2 = samx.matcher(row);
            counter += matcher1.groupCount() + matcher2.groupCount();
        }
        return counter;
    }

    private boolean search() {



        return false;
    }

    @Override
    public String evalPart2() {
        return null;
    }

    private String[][] deepCopy() {
        String[][] copy = new String[this.matrixDimentions][this.matrixDimentions];
        for (int i = 0; i < this.matrixDimentions; i++) {
            System.arraycopy(this.baseMatrix[i], 0, copy[i], 0, this.matrixDimentions);
        }
        return copy;
    }
}
