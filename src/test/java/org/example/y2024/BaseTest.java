package org.example.y2024;

import org.example.framework.Day;

import java.util.List;

public interface BaseTest {

    Day getDay();

    List<String> getPart1TestData();

    default List<String> getPart2TestData() {
        return getPart1TestData();
    }

    String getPart1ExpectedResult();

    String getPart2ExpectedResult();

}
