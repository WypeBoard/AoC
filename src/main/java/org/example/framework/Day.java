package org.example.framework;

import java.util.ArrayList;
import java.util.List;

public abstract class Day {

    private List<String> rawInput = new ArrayList<>();

    public final DailyResult run() {
        parseInput();
        return evaluate();
    }

    public final DailyResult testRunPart1(List<String> testInput) {
        rawInput = testInput;
        parseInput();
        String part1 = evalPart1();
        return new DailyResult(part1, "");
    }

    public final DailyResult testRunPart2(List<String> testInput) {
        rawInput = testInput;
        parseInput();
        String part2 = evalPart2();
        return new DailyResult("", part2);
    }
    public final List<String> getInput() {
        if (rawInput.isEmpty()) {
            rawInput = FileReader.read(Integer.parseInt(getClass().getSimpleName().substring(3)));
        }
        return rawInput;
    }

    private final DailyResult evaluate() {
        String part1 = evalPart1();
        String part2 = evalPart2();
        return new DailyResult(part1, part2);
    }


    /**
     * Helper method pre-parsing the input before using it for eval part1 and 2
     */
    public abstract void parseInput();

    /**
     * Evaluate part 1
     * @return
     */
    public abstract String evalPart1();

    /**
     * Evaluate part 2
     * @return
     */
    public abstract String evalPart2();
}
