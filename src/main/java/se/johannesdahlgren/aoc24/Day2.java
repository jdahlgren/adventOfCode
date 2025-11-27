package se.johannesdahlgren.aoc24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day2 {

  private static final String FILE_PATH = "src/main/resources/2024/day2";

  public int part1() throws IOException {
    return countValidLinesPart1(FILE_PATH);
  }

  public int part2() throws IOException {
    return countValidLinesPart2(FILE_PATH);
  }

  private int countValidLinesPart1(String filePath) throws IOException {
    return Files.readAllLines(Path.of(filePath)).stream()
        .map(this::parseNumbers)
        .mapToInt(this::isValidSequencePart1)
        .sum();
  }

  private int countValidLinesPart2(String filePath) throws IOException {
    return Files.readAllLines(Path.of(filePath)).stream()
        .map(this::parseNumbers)
        .mapToInt(this::canBeValid)
        .sum();
  }

  private List<Integer> parseNumbers(String line) {
    return Arrays.stream(line.trim().split("\\s+"))
        .map(Integer::parseInt)
        .toList();
  }

  private int canBeValid(List<Integer> numbers) {
    // If it's already valid, return 1
    if (isValidSequence(numbers)) {
      return 1;
    }

    // Try removing each number one at a time
    for (int i = 0; i < numbers.size(); i++) {
      List<Integer> modified = new ArrayList<>(numbers);
      modified.remove(i);
      if (isValidSequence(modified)) {
        return 1;
      }
    }

    return 0;
  }

  private int isValidSequencePart1(List<Integer> numbers) {
    if (isValidSequence(numbers)) {
      return 1;
    }
    return 0;
  }

  private boolean isValidSequence(List<Integer> numbers) {
    if (numbers.size() < 2) return true;

    boolean increasing = true;
    boolean decreasing = true;

    for (int i = 1; i < numbers.size(); i++) {
      int difference = numbers.get(i) - numbers.get(i - 1);

      // Check if sequence breaks the rules
      if ((difference <= 0 || difference > 3) &&
          (difference >= 0 || difference < -3)) {
        return false;
      }

      if (difference > 0) decreasing = false;
      if (difference < 0) increasing = false;

      // If neither increasing nor decreasing is possible
      if (!increasing && !decreasing) {
        return false;
      }
    }

    return true;
  }
}
