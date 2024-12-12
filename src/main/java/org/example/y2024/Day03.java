package org.example.y2024;

import org.example.framework.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Day03 extends Day {

    private List<String> input = new ArrayList<>();

    @Override
    public void parseInput() {
        input = getInput();
    }

    @Override
    public String evalPart1() {
        Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)");
        List<Integer> result = new ArrayList<>();
        input.forEach(row -> {
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) {
                String group = matcher.group();
                String[] splits = group.split("\\(")[1].split(",");
                int first = Integer.parseInt(splits[0]);
                int second = Integer.parseInt(splits[1].substring(0, splits[1].length() - 1));
                result.add(first * second);
            }
        });
        return String.valueOf(result.stream().reduce(0, Integer::sum));
    }

    @Override
    public String evalPart2() {
        Pattern pattern = Pattern.compile("(?:mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\))");
        List<Integer> result = new ArrayList<>();
        boolean runInstructions = true;
        for (String row : input) {
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) {
                String group = matcher.group();
                if ("don't()".equals(group)) {
                    runInstructions = false;
                    continue;
                }
                if ("do()".equals(group)) {
                    runInstructions = true;
                    continue;
                }
                if (!runInstructions) {
                    continue;
                }
                String[] splits = group.split("\\(")[1].split(",");
                int first = Integer.parseInt(splits[0]);
                int second = Integer.parseInt(splits[1].substring(0, splits[1].length() - 1));
                result.add(first * second);
            }
        }
        return String.valueOf(result.stream().reduce(0, Integer::sum));
    }
}
