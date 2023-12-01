package com.scavi.aoc.y2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01Trebuchet {
  private final Map<String, Integer> NUMBER_MAPPING = Map.of(
          "one", 1,
          "two", 2,
          "three", 3,
          "four", 4,
          "five", 5,
          "six", 6,
          "seven", 7,
          "eight", 8,
          "nine", 9
  );

  public int solveA(final String[] input) {
    return execute(input, Pattern.compile("\\d"));
  }

  public int solveB(final String[] input) {
    return execute(input, Pattern.compile("\\d|one|two|three|four|five|six|seven|eight|nine"));
  }

  private int execute(final String[] input, final Pattern pattern) {
    return Arrays.stream(input)
            .map(line -> findIntegers(line, pattern))
            .mapToInt(integers -> Integer.parseInt(String.format("%s%s", integers.get(0), integers.get(integers.size() - 1))))
            .sum();
  }

  private List<Integer> findIntegers(final String line, final Pattern pattern) {
    List<Integer> integers = new ArrayList<>();
    String tmp = line;
    while (!tmp.isEmpty()) {
      Matcher matcher = pattern.matcher(tmp);
      if (matcher.find()) {
        String found = matcher.group();
        integers.add(NUMBER_MAPPING.containsKey(found) ? NUMBER_MAPPING.get(found) : Integer.parseInt(found));
        tmp = tmp.substring(matcher.start() + 1);
      } else {
        tmp = "";
      }
    }
    return integers;
  }
}
