package com.scavi.aoc.y2023;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03GearRatios {
  private static final Pattern NUMBERS = Pattern.compile("\\d+");
  private static final Pattern HAS_SYMBOL = Pattern.compile("[^0-9|.]");
  private static final Pattern GEAR_ANGLE = Pattern.compile("\\*");

  public long solveA(final String[] engineSchematic) {
    long result = 0;
    for (int y = 0; y < engineSchematic.length; ++y) {
      String line = engineSchematic[y];
      Matcher numberMatcher = NUMBERS.matcher(line);
      while (numberMatcher.find()) {
        boolean isValidNumber = isValidNumber(engineSchematic, numberMatcher, y - 1);
        isValidNumber |= isValidNumber(engineSchematic, numberMatcher, y);
        isValidNumber |= isValidNumber(engineSchematic, numberMatcher, y + 1);
        if (isValidNumber) {
          result += Integer.parseInt(numberMatcher.group());
        }
      }
    }
    return result;
  }

  public long solveB(final String[] engineSchematic) {
    long result = 0;
    List<Point> gearLocations = findGearLocations(engineSchematic);
    for (Point gearLocation : gearLocations) {
      result += findSurroundingNumbers(engineSchematic, gearLocation);
    }
    return result;
  }

  private int findSurroundingNumbers(final String[] engineSchematic, final Point gearLocation) {
    List<Integer> numbers = new ArrayList<>();
    for (int y = (int) Math.max(0, gearLocation.getY() - 1); y <= Math.min(gearLocation.getY() + 1, engineSchematic[0].length()); ++y) {
      String line = engineSchematic[y];
      Matcher numberMatcher = NUMBERS.matcher(line);
      while (numberMatcher.find()) {
        if (numberMatcher.start() - 1 <= gearLocation.getX() && numberMatcher.end() >= gearLocation.getX()) {
          numbers.add(Integer.parseInt(numberMatcher.group()));
        }
      }
    }
    return numbers.size() == 2 ? numbers.get(0) * numbers.get(1) : 0;
  }

  private List<Point> findGearLocations(final String[] engineSchematic) {
    List<Point> gearLocations = new ArrayList<>();
    for (int y = 0; y < engineSchematic.length; ++y) {
      Matcher gearMatcher = GEAR_ANGLE.matcher(engineSchematic[y]);
      while (gearMatcher.find()) {
        gearLocations.add(new Point(gearMatcher.start(), y));
      }
    }
    return gearLocations;
  }

  private boolean isValidNumber(
          final String[] engineSchematic,
          final Matcher matcher,
          final int row) {
    if (row < 0 || row >= engineSchematic.length) {
      return false;
    }
    int start = Math.max(matcher.start() - 1, 0);
    int end = Math.min(matcher.end() + 1, engineSchematic[0].length());
    return HAS_SYMBOL.matcher(engineSchematic[row].substring(start, end)).find();
  }
}
