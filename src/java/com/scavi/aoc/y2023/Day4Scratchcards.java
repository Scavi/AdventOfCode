package com.scavi.aoc.y2023;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day4Scratchcards {
  private final Pattern WINNING_NUMBERS = Pattern.compile("(?<=:)[^|]*");
  private final Pattern MY_NUMBERS = Pattern.compile("(?<=\\|\\s)[^$]*");

  public long solveA(final String[] cards) {
    return execute(cards, null);
  }

  public long solveB(final String[] cards) {
    int[] cache = new int[cards.length];
    Arrays.fill(cache, 1);
    execute(cards, cache);
    return Arrays.stream(cache).sum();
  }

  private long execute(final String[] cards, final int[] cache) {
    long result = 0;
    for (int i = 0; i < cards.length; ++i) {
      for (int j = 0; j < (cache != null ? cache[i] : 1); ++j) {
        String card = cards[i];
        Set<Integer> winningNumbers = determineIntegers(WINNING_NUMBERS, card);
        Set<Integer> myNumbers = determineIntegers(MY_NUMBERS, card);
        myNumbers.retainAll(winningNumbers);
        if (cache != null) {
          for (int k = i + 1; k <= Math.min(myNumbers.size() + i, cards.length - 1); ++k) {
            cache[k]++;
          }
        }
        result += myNumbers.size() > 0 ? Math.pow(2, myNumbers.size() - 1) : 0;
      }
    }
    return result;
  }

  private Set<Integer> determineIntegers(final Pattern pattern, final String card) {
    Matcher matcher = pattern.matcher(card);
    if (matcher.find()) {
      return Arrays.stream(Arrays.stream(matcher.group().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray())
              .boxed()
              .collect(Collectors.toCollection(HashSet::new));
    }
    throw new RuntimeException("That was unexpected...");
  }
}
