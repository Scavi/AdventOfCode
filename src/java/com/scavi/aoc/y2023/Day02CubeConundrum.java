package com.scavi.aoc.y2023;

import java.util.HashMap;
import java.util.Map;

public class Day02CubeConundrum {
  @FunctionalInterface
  private interface Calculation<T> {
    T execute(final Map<String, Integer> loadedCubes, Map<String, Integer> reveals, final int pos);
  }

  private final Map<String, Integer> loadedCubes;

  public Day02CubeConundrum(final Map<String, Integer> loadedCubes) {
    this.loadedCubes = loadedCubes;
  }

  public int solveA(final String[] input) {
    return evaluate(input, loadedCubes, Day02CubeConundrum::calculateA);
  }

  public int solveB(final String[] input) {
    return evaluate(input, loadedCubes, Day02CubeConundrum::calculateB);
  }

  private int evaluate(final String[] input, Map<String, Integer> loadedCubes, final Calculation<Integer> calculate) {
    int result = 0;
    for (int i = 0; i < input.length; ++i) {
      input[i] = input[i].replaceAll("Game \\d+: ", "");
    }
    int pos = 1;
    for (String game : input) {
      Map<String, Integer> reveals = new HashMap<>();
      String[] cubeSets = game.split(";");
      for (String cubesSet : cubeSets) {
        String[] cubes = cubesSet.split(",");
        for (String cube : cubes) {
          cube = cube.trim();
          String color = cube.split(" ")[1];
          int number = Integer.parseInt(cube.trim().split(" ")[0]);
          reveals.put(color, Math.max(reveals.getOrDefault(color, number), number));
        }
      }
      result += calculate.execute(loadedCubes, reveals, pos);
      pos++;
    }
    return result;
  }

  private static int calculateA(final Map<String, Integer> loadedCubes, Map<String, Integer> reveals, final int pos) {
    boolean isValid = true;
    int result = 0;
    for (var loaded : loadedCubes.entrySet()) {
      isValid &= reveals.getOrDefault(loaded.getKey(), 0) <= loaded.getValue();
    }
    if (isValid) {
      result += pos;
    }
    return result;
  }

  private static int calculateB(final Map<String, Integer> loadedCubes, Map<String, Integer> reveals, final int pos) {
    return reveals.values().stream().reduce(1, (a, b) -> a * b);
  }
}
