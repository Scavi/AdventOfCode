package com.scavi.aoc.y2023;

import com.scavi.aoc.util.FileHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day03GearRatiosTest {
  @Test
  public void testPreparationA() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day03Preparation.txt"));
    Day03GearRatios day3 = new Day03GearRatios();
    long result = day3.solveA(input);
    Assertions.assertEquals(4361, result);
  }

  @Test
  public void testSolveA() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day03.txt"));
    Day03GearRatios day3 = new Day03GearRatios();
    long result = day3.solveA(input);
    Assertions.assertEquals(535351, result);
  }

  @Test
  public void testPreparationB() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day03Preparation.txt"));
    Day03GearRatios day3 = new Day03GearRatios();
    long result = day3.solveB(input);
    Assertions.assertEquals(467835, result);
  }

  @Test
  public void testSolveB() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day03.txt"));
    Day03GearRatios day3 = new Day03GearRatios();
    long result = day3.solveB(input);
    Assertions.assertEquals(87287096, result);
  }
}
