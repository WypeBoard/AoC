package org.example.y2024;


import org.example.framework.Day;

import java.util.List;

class Day01Test implements BaseTest {

    @Override
    public Day getDay() {
        return new Day01();
    }

    @Override
    public List<String> getPart1TestData() {
        return List.of(
                "3 4",
                "4 3",
                "2 5",
                "1 3",
                "3 9",
                "3 3"
        );
    }

    @Override
    public String getPart1ExpectedResult() {
        return "11";
    }

    @Override
    public String getPart2ExpectedResult() {
        return "31";
    }
}