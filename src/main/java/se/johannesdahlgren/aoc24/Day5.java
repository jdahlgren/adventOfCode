package se.johannesdahlgren.aoc24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import se.johannesdahlgren.util.IntPair;

public class Day5 {
  private final List<IntPair> rules = new ArrayList<>();
  private final List<List<Integer>> numberLists = new ArrayList<>();

  public void loadFromFile(String filePath) throws IOException {
    Path path = Paths.get(filePath);
    List<String> lines = Files.readAllLines(path);
    boolean isParsingRules = true;

    for (String line : lines) {
      if (line.trim().isEmpty()) {
        isParsingRules = false;
        continue;
      }

      if (isParsingRules) {
        String[] parts = line.split("\\|");
        rules.add(new IntPair(
            Integer.parseInt(parts[0].trim()),
            Integer.parseInt(parts[1].trim())
        ));
      } else {
        List<Integer> numbers = Arrays.stream(line.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .toList();
        numberLists.add(numbers);
      }
    }
  }

  public int sumMiddleNumbersOfFixedInvalidLists() {
    return numberLists.stream()
        .filter(list -> !isValidNumberList(list))  // Only process invalid lists
        .map(this::fixNumberList)
        .map(this::getMiddleNumber)
        .mapToInt(Integer::intValue)
        .sum();
  }

  private List<Integer> fixNumberList(List<Integer> numbers) {
    List<Integer> mutableNumbers = new ArrayList<>(numbers);
    boolean needsFixing = true;

    while (needsFixing) {
      needsFixing = false;
      for (IntPair rule : rules) {
        int beforeIndex = mutableNumbers.indexOf(rule.left());
        int afterIndex = mutableNumbers.indexOf(rule.right());

        if (beforeIndex != -1 && afterIndex != -1 && beforeIndex > afterIndex) {
          // Swap the numbers to fix the order
          int temp = mutableNumbers.get(beforeIndex);
          mutableNumbers.set(beforeIndex, mutableNumbers.get(afterIndex));
          mutableNumbers.set(afterIndex, temp);
          needsFixing = true;
        }
      }
    }
    return mutableNumbers;
  }

  public int sumMiddleNumbersOfValidLists() {
    return numberLists.stream()
        .filter(this::isValidNumberList)
        .map(this::getMiddleNumber)
        .mapToInt(Integer::intValue)
        .sum();
  }

  private Integer getMiddleNumber(List<Integer> numbers) {
    int middleIndex = numbers.size() / 2;
    return numbers.get(middleIndex);
  }

  private boolean isValidNumberList(List<Integer> numbers) {
    return rules.stream().allMatch(rule -> isValidRule(numbers, rule));
  }

  private boolean isValidRule(List<Integer> numbers, IntPair rule) {
    int beforeIndex = numbers.indexOf(rule.left());
    int afterIndex = numbers.indexOf(rule.right());

    // If either number is not in the list, the rule doesn't apply
    if (beforeIndex == -1 || afterIndex == -1) {
      return true;
    }

    // Check if the before number comes before the after number
    return beforeIndex < afterIndex;
  }
}
