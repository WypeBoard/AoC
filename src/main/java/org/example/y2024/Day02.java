package org.example.y2024;

import org.example.framework.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day02 extends Day {

    private List<List<Integer>> parsedInput = new ArrayList<>();

    @Override
    public void parseInput() {
        List<String> input = getInput();
        input.forEach(row -> {
            List<String> strings = Arrays.asList(row.split(" "));
            List<Integer> integerList = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
            parsedInput.add(integerList);
        });
    }

    /**
     * Rules:
     * - A list must always be incresing or decreasing
     * - Any two adjacent levels needs to differ by 1, 2 or 3
     *
     * @return How many rows uphold the rules?
     */
    @Override
    public String evalPart1() {
        long safeReports = parsedInput.stream().map(this::isSafe).filter(Boolean.TRUE::equals).count();
        return String.valueOf(safeReports);
    }

    private boolean isSafe(List<Integer> integers) {
        boolean safeReport = false;
        Integer previousDirection = null; // -1 decrease - 1 increase
        for (int index = 1; index < integers.size(); index++) {
            Integer value = integers.get(index) - integers.get(index - 1);

            // Check for the direction - Increase or decrease
            if (value == 0) {
                break;
            }
            int currentDirection = value > 0 ? 1 : -1;
            if (previousDirection == null) {
                previousDirection = currentDirection;
            }
            if (currentDirection != previousDirection) {
                break;
            }

            // 0-diff is taken care of.
            // Ensure that the diff is no more than 3.
            if (Math.abs(value) > 3) {
                break;
            }
            if (index == integers.size() - 1) {
                safeReport = true;
            }
        }
        return safeReport;
    }

    @Override
    public String evalPart2() {
        long safeReports = parsedInput.stream().map(this::isTolerantSafe).filter(Boolean.TRUE::equals).count();
        return String.valueOf(safeReports);
    }

    private boolean isTolerantSafe(List<Integer> integers) {
        boolean safe = isSafe(integers);
        if (!safe) {
            int[] basicList = integers.stream().mapToInt(i->i).toArray();
            for (int i = 0; i < integers.size(); i++) {
                int[] omitList = new int[integers.size() - 1];

                System.arraycopy(basicList, 0, omitList, 0, i);
                System.arraycopy(basicList, i + 1, omitList, i, omitList.length - i);

                List<Integer> newTestList = Arrays.stream(omitList).boxed().toList();
                if (isSafe(newTestList)) {
                    safe = true;
                    break;
                }
            }
        }
        return safe;
    }
}
