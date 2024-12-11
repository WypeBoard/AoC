package org.example.y2024;

import org.example.framework.Day;

import java.util.List;

public class Day03Test implements BaseTest {
    @Override
    public Day getDay() {
        return new Day03();
    }

    @Override
    public List<String> getPart1TestData() {
        return List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
    }

    @Override
    public List<String> getPart2TestData() {
        return List.of("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))");
    }

    @Override
    public String getPart1ExpectedResult() {
        return "161";
    }

    @Override
    public String getPart2ExpectedResult() {
        return "48";
    }
}
