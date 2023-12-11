package com.scavi.aoc.y2023;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day11CosmicExpansion {
  private final int galaxySize;

  public Day11CosmicExpansion(final int galaxySize) {
    this.galaxySize = galaxySize;
  }

  public long solveA(final String[] image) {
    Set<Integer> rowsWithGalaxies = new HashSet<>();
    Set<Integer> columnsWithGalaxies = new HashSet<>();
    ArrayList<Point> galaxyLocations = new ArrayList<>();
    for (int y = 0; y < image.length; ++y) {
      for (int x = 0; x < image.length; ++x) {
        if (image[y].charAt(x) == '#') {
          galaxyLocations.add(new Point(x, y));
          columnsWithGalaxies.add(y);
          rowsWithGalaxies.add(x);
        }
      }
    }
    long distance = 0;
    for (int i = 0; i < galaxyLocations.size() - 1; ++i) {
      for (int j = i + 1; j < galaxyLocations.size(); ++j) {
        distance += calculateDistance(galaxyLocations.get(i), galaxyLocations.get(j), rowsWithGalaxies, columnsWithGalaxies);
      }
    }
    return distance;
  }

  private long calculateDistance(
          final Point galaxy1,
          final Point galaxy2,
          final Set<Integer> rowsWithGalaxies,
          final Set<Integer> columnsWithGalaxies) {
    return Math.abs(galaxy1.x - galaxy2.x) + Math.abs(galaxy1.y - galaxy2.y)
            + expansionSize(rowsWithGalaxies, galaxy1.x, galaxy2.x)
            + expansionSize(columnsWithGalaxies, galaxy1.y, galaxy2.y);
  }

  private long expansionSize(final Set<Integer> galaxies, final int a, final int b) {
    int size = 0;
    for (int i = Math.min(a, b) + 1; i <= Math.max(a, b) - 1; ++i) {
      if (!galaxies.contains(i)) {
        size += this.galaxySize;
      }
    }
    return size;
  }
}
