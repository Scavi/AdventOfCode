package com.scavi.aoc.util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileHelper {
  public static File forUnitTests(final String inputFile) {
    Path path = Paths.get(System.getProperty("user.dir"), "input", inputFile);
    File file = new File(path.toString());
    if (!file.exists()) {
      throw new IllegalArgumentException(
              String.format("The input file '%s' doesn't exist!", file.getAbsolutePath()));
    }
    return file;
  }

  /**
   * Reads the given file and return the lines as array while each line is represented by the
   * corresponding array position
   *
   * @param file the file to read
   * @return the array with the lines of the file
   */
  public static String[] readLines(final File file) throws IOException {
    List<String> lines = new LinkedList<>();
    Scanner scanner = new Scanner(file);
    while (scanner.hasNextLine()) {
      lines.add(scanner.nextLine());
    }
    return lines.toArray(new String[lines.size()]);
  }
}
