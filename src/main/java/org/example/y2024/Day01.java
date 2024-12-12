package org.example.y2024;

import org.example.framework.Day;

import java.util.*;
import java.util.stream.IntStream;

public class Day01 extends Day {

    List<Integer> firstList = new ArrayList<>();
    List<Integer> secondList = new ArrayList<>();

    @Override
    public void parseInput() {
        List<String> rawInput = getInput();
        rawInput.forEach(row -> {
            String[] split = row.split(" ");
            firstList.add(Integer.parseInt(split[0]));
            secondList.add(Integer.parseInt(split[1]));
        });
    }

    @Override
    public String evalPart1() {
        // sort lists
        List<Integer> result = new ArrayList<>();
        firstList.sort(Comparator.naturalOrder());
        secondList.sort(Comparator.naturalOrder());
        IntStream.range(0, firstList.size()).forEach(index -> {
            Integer first = firstList.get(index);
            Integer second = secondList.get(index);
            result.add(Math.abs(first - second));
        });
        return String.valueOf(result.stream().reduce(0, Integer::sum));
    }

    @Override
    public String evalPart2() {
        Map<Integer, Integer> accumulations = new HashMap<>();
        secondList.forEach(number -> {
            if (!accumulations.containsKey(number)) {
                accumulations.put(number, 0);
            }
            accumulations.compute(number, (key, val) -> (val == null) ? 0 : val + 1);
        });
        List<Integer> result = new ArrayList<>();
        firstList.forEach(number -> {
            Integer accumulationsOrDefault = accumulations.getOrDefault(number, 0);
            int sum = number * accumulationsOrDefault;
            result.add(sum);
        });
        return String.valueOf(result.stream().reduce(0, Integer::sum));
    }
}
