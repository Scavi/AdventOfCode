package com.scavi.aoc.y2023;

import com.scavi.aoc.util.FileHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day4ScratchcardsTest {

  @Test
  public void testPreparationA() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day04Preparation.txt"));
    Day4Scratchcards day4 = new Day4Scratchcards();
    long result = day4.solveA(input);
    Assertions.assertEquals(13, result);
  }

  @Test
  public void testSolveA() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day04.txt"));
    Day4Scratchcards day4 = new Day4Scratchcards();
    long result = day4.solveA(input);
    Assertions.assertEquals(21088, result);
  }

  @Test
  public void testPreparationB() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day04Preparation.txt"));
    Day4Scratchcards day4 = new Day4Scratchcards();
    long result = day4.solveB(input);
    Assertions.assertEquals(30, result);
  }

  @Test
  public void testSolveB() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day04.txt"));
    Day4Scratchcards day4 = new Day4Scratchcards();
    long result = day4.solveB(input);
    Assertions.assertEquals(6874754, result);
  }
}
