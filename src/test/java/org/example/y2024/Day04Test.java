
package org.example.y2024;

import org.example.framework.Day;

import java.util.List;

public class Day04Test implements BaseTest {
    @Override
    public Day getDay() {
        return new Day04();
    }

    @Override
    public List<String> getPart1TestData() {
        return List.of(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"
        );
    }

    @Override
    public String getPart1ExpectedResult() {
        return "18";
    }

    @Override
    public String getPart2ExpectedResult() {
        return null;
    }
}
