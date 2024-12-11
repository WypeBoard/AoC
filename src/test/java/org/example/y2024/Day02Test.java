package org.example.y2024;

import org.example.framework.Day;

import java.util.List;

public class Day02Test implements BaseTest {
    @Override
    public Day getDay() {
        return new Day02();
    }

    @Override
    public List<String> getPart1TestData() {
        return List.of(
                "7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 3 6 7 9"
        );
    }

    @Override
    public String getPart1ExpectedResult() {
        return "2";
    }

    @Override
    public String getPart2ExpectedResult() {
        return "4";
    }
}
