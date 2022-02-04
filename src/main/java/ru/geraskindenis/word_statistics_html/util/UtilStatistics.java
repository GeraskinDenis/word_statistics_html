package ru.geraskindenis.word_statistics_html.util;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class UtilStatistics {
    public static Map<String, Integer> getNumberOfRepetitions(String text) {
        String[] strings = text.split("\\s+");
        strings = Arrays.stream(strings)
                .map(String::toUpperCase)
                .toArray(String[]::new);
        Map<String, Integer> result = new HashMap<>();
        for (String s : strings) {
            Integer integer = result.get(s);
            result.put(s, (integer == null) ? 1 : ++integer);
        }
        return result;
    }
}
