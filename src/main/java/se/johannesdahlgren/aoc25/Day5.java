package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

  private final List<Range> freshIngredientIdRanges;
  private final List<Long> ingredientIds;

  public Day5(String fileName) {
    List<String> database = FileUtil.toLines(FileUtil.getPath("2025", "day5." + fileName));
    int splitIndex = database.indexOf("");
    List<String> freshRanges = database.subList(0, splitIndex);
    freshIngredientIdRanges = freshRanges.stream()
        .map(r -> new Range(Long.parseLong(r.split("-")[0]), Long.parseLong(r.split("-")[1])))
        .sorted()
        .toList();
    ingredientIds = database.subList(splitIndex + 1, database.size()).stream()
        .map(Long::parseLong)
        .toList();
  }

  public int numberOfFreshIngredients() {
    int numberOfFreshIngredients = 0;

    for (Long ingredientId : ingredientIds) {
      for (Range freshIngredientIdRange : freshIngredientIdRanges) {
        boolean ingredientIdWithinRange = Math.max(ingredientId, freshIngredientIdRange.start)
            == Math.min(ingredientId, freshIngredientIdRange.end);
        if (ingredientIdWithinRange) {
          numberOfFreshIngredients++;
          break;
        }
      }
    }
    return numberOfFreshIngredients;
  }

  public long countAllFreshIds() {
    List<Range> uniqueIngredientIdRanges = new ArrayList<>();

    for (Range freshIngredientIdRange : freshIngredientIdRanges) {

      boolean isHandled = false;
      for (Range uniqueIngredientIdRange : uniqueIngredientIdRanges) {
        boolean freshStartWithinUniqueInterval = Math.max(freshIngredientIdRange.start, uniqueIngredientIdRange.start)
            == Math.min(freshIngredientIdRange.start, uniqueIngredientIdRange.end);
        boolean freshEndWithinUniqueInterval = Math.max(freshIngredientIdRange.end, uniqueIngredientIdRange.start)
            == Math.min(freshIngredientIdRange.end, uniqueIngredientIdRange.end);

        if (freshStartWithinUniqueInterval && freshEndWithinUniqueInterval) {
          isHandled = true;
          break;
        } else if (freshStartWithinUniqueInterval) {
          uniqueIngredientIdRange.setEnd(freshIngredientIdRange.end);
          isHandled = true;
          break;
        } else if (freshEndWithinUniqueInterval) {
          uniqueIngredientIdRange.setStart(freshIngredientIdRange.start);
          isHandled = true;
          break;
        }
      }
      if (!isHandled) {
        uniqueIngredientIdRanges.add(freshIngredientIdRange);
      }
    }

    return uniqueIngredientIdRanges.stream()
        .map(Range::numberOfFreshIds)
        .reduce(Long::sum)
        .orElse(0L);
  }

  private static final class Range implements Comparable<Range> {
    private Long start;
    private Long end;

    private Range(Long start, Long end) {
      this.start = start;
      this.end = end;
    }

    public void setStart(Long start) {
      this.start = start;
    }

    public void setEnd(Long end) {
      this.end = end;
    }

    public long numberOfFreshIds() {
      return end - start + 1;
    }

    @Override
    public int compareTo(Range otherRange) {
      int startCompare = this.start.compareTo(otherRange.start);
      if (startCompare == 0) {
        return this.end.compareTo(otherRange.end);
      }
      return startCompare;
    }
  }
}
