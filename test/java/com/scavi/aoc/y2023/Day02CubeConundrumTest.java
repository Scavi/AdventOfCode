package com.scavi.aoc.y2023;

import com.scavi.aoc.util.FileHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

public class Day02CubeConundrumTest {
  @Test
  public void testPreparationA() throws IOException {
    Map<String, Integer> loadedCubes = Map.of("red", 12, "green", 13, "blue", 14);
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day02Preparation.txt"));
    Day02CubeConundrum day2 = new Day02CubeConundrum(loadedCubes);
    int result = day2.solveA(input);
    Assertions.assertEquals(8, result);
  }

  @Test
  public void testPreparationB() throws IOException {
    Map<String, Integer> loadedCubes = Map.of("red", 12, "green", 13, "blue", 14);
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day02Preparation.txt"));
    Day02CubeConundrum day2 = new Day02CubeConundrum(loadedCubes);
    int result = day2.solveB(input);
    Assertions.assertEquals(2286, result);
  }

  @Test
  public void testSolveA() throws IOException {
    Map<String, Integer> loadedCubes = Map.of("red", 12, "green", 13, "blue", 14);
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day02.txt"));
    Day02CubeConundrum day2 = new Day02CubeConundrum(loadedCubes);
    int result = day2.solveA(input);
    Assertions.assertEquals(2331, result);
  }

  @Test
  public void testSolveB() throws IOException {
    Map<String, Integer> loadedCubes = Map.of("red", 12, "green", 13, "blue", 14);
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day02.txt"));
    Day02CubeConundrum day2 = new Day02CubeConundrum(loadedCubes);
    int result = day2.solveB(input);
    Assertions.assertEquals(71585, result);
  }
}
