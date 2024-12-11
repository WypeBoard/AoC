package org.example.y2024;

import org.example.framework.DailyResult;
import org.example.framework.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

public class TestDay {

    // Method to provide test data
    static Stream<BaseTest> provideImplementations() {
        return Stream.of(
                /*new Day01Test(),*/
                /*new Day02Test(),*/
                new Day03Test()
        );
    }

    @ParameterizedTest
    @MethodSource("provideImplementations")
    void testProcessMethod(BaseTest testDayData) {

        List<String> part1TestData = testDayData.getPart1TestData();
        List<String> part2TestData = testDayData.getPart2TestData();

        Day day1 = testDayData.getDay();
        Day day2 = testDayData.getDay();
        DailyResult dailyResult1 = day1.testRunPart1(part1TestData);
        DailyResult dailyResult2 = day2.testRunPart2(part2TestData);

        Assertions.assertEquals(dailyResult1.part1(), testDayData.getPart1ExpectedResult());
        Assertions.assertEquals(dailyResult2.part2(), testDayData.getPart2ExpectedResult());
    }
}
