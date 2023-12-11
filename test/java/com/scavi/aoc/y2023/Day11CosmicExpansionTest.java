package com.scavi.aoc.y2023;

import com.scavi.aoc.util.FileHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day11CosmicExpansionTest {
  @Test
  public void testPreparationA() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day11Preparation.txt"));
    Day11CosmicExpansion day11 = new Day11CosmicExpansion(1);
    long result = day11.solveA(input);
    Assertions.assertEquals(374, result);
  }

  @Test
  public void testSolveA() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day11.txt"));
    Day11CosmicExpansion day11 = new Day11CosmicExpansion(1);
    long result = day11.solveA(input);
    Assertions.assertEquals(9799681, result);
  }

  @Test
  public void testPreparationB1() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day11Preparation.txt"));
    Day11CosmicExpansion day11 = new Day11CosmicExpansion(9);
    long result = day11.solveA(input);
    Assertions.assertEquals(1030, result);
  }

  @Test
  public void testPreparationB2() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day11Preparation.txt"));
    Day11CosmicExpansion day11 = new Day11CosmicExpansion(99);
    long result = day11.solveA(input);
    Assertions.assertEquals(8410, result);
  }

  @Test
  public void testSolveB() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day11.txt"));
    Day11CosmicExpansion day11 = new Day11CosmicExpansion(999999);
    long result = day11.solveA(input);
    Assertions.assertEquals(513171773355L, result);
  }
}
