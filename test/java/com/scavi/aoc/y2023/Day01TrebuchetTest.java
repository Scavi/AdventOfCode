package com.scavi.aoc.y2023;

import com.scavi.aoc.util.FileHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day01TrebuchetTest {

  @Test
  public void testPreparationA() {
    String[] input = new String[]{"1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet" };
    Day01Trebuchet day1 = new Day01Trebuchet();
    int result = day1.solveA(input);
    Assertions.assertEquals(142, result);
  }

  @Test
  public void testPreparationB() {
    String[] input = new String[]{
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen"
    };
    Day01Trebuchet day1 = new Day01Trebuchet();
    int result = day1.solveB(input);
    Assertions.assertEquals(281, result);
  }

  @Test
  public void testExceptionCase() {
    String[] input = new String[]{"6twodndmhcgxlgbqbqndbbthnngblfgtzh5fouroneightrjp" };
    Day01Trebuchet day1 = new Day01Trebuchet();
    int result = day1.solveB(input);
    Assertions.assertEquals(68, result);
  }

  @Test
  public void testSolveA() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day01.txt"));
    Day01Trebuchet day1 = new Day01Trebuchet();
    int result = day1.solveA(input);
    Assertions.assertEquals(54390, result);
  }

  @Test
  public void testSolveB() throws IOException {
    String[] input = FileHelper.readLines(FileHelper.forUnitTests("y2023/Day01.txt"));
    Day01Trebuchet day1 = new Day01Trebuchet();
    int result = day1.solveB(input);
    Assertions.assertEquals(54277, result);
  }
}
