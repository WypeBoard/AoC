package org.example;

import org.example.framework.DailyResult;
import org.example.framework.Day;
import org.example.y2024.Day01;
import org.example.y2024.Day02;
import org.example.y2024.Day03;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Integer, Day> days = new HashMap<>();

    public static void main(String[] args) {
        runDays();
    }

    private static void runDays() {
        days.put(1, new Day01());
        days.put(2, new Day02());
        days.put(3, new Day03());
        days.forEach((day, cons) -> {
            DailyResult result = cons.run();
            System.out.println("Day " + day + ":");
            System.out.println("Part 1: " + result.part1());
            System.out.println("Part 2: " + result.part2());
            System.out.println("\n\n");
        });
    }
}