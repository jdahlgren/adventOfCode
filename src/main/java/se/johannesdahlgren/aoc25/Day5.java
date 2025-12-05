package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.List;

public class Day5 {

  private final List<String> freshRanges;
  private final List<Long> ingredientIds;

  public Day5(String fileName) {
    List<String> database = FileUtil.toLines(FileUtil.getPath("2025", "day5." + fileName));
    int splitIndex = database.indexOf("");
    freshRanges = database.subList(0, splitIndex);
    ingredientIds = database.subList(splitIndex + 1, database.size()).stream()
        .map(Long::parseLong)
        .toList();
  }

  public int numberOfFreshIngredients() {
    int numberOfFreshIngredients = 0;

    for (Long ingredientId : ingredientIds) {
      for (String freshRange : freshRanges) {
        String[] split = freshRange.split("-");
        if (Math.max(ingredientId, Long.parseLong(split[0])) == Math.min(ingredientId, Long.parseLong(split[1]))) {
          numberOfFreshIngredients++;
          break;
        }
      }
    }
    return numberOfFreshIngredients;
  }
}
