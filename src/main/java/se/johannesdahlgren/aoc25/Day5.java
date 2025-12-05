package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.ArrayList;
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

  public long countAllFreshIds() {
    List<Interval> uniqueRanges = new ArrayList<>();
    List<Interval> freshIntervals = freshRanges.stream()
        .map(r -> new Interval(Long.parseLong(r.split("-")[0]), Long.parseLong(r.split("-")[1])))
        .sorted()
        .toList();
    for (Interval freshInterval : freshIntervals) {

      boolean isHandled = false;
      for (Interval uniqueInterval : uniqueRanges) {
        boolean freshStartWithinUniqueInterval = Math.max(freshInterval.start, uniqueInterval.start) == Math.min(freshInterval.start, uniqueInterval.end);
        boolean freshEndWithinUniqueInterval = Math.max(freshInterval.end, uniqueInterval.start) == Math.min(freshInterval.end, uniqueInterval.end);

        if (freshStartWithinUniqueInterval && freshEndWithinUniqueInterval) {
          // fully within existing range, throw
          isHandled = true;
          break;
        } else if (freshStartWithinUniqueInterval) {
          uniqueInterval.setEnd(freshInterval.end);
          isHandled = true;
          break;
        } else if (freshEndWithinUniqueInterval) {
          uniqueInterval.setStart(freshInterval.start);
          isHandled = true;
          break;
        }
      }
      if (!isHandled) {
        uniqueRanges.add(freshInterval);
      }
    }

    return uniqueRanges.stream()
        .map(Interval::numberOfFreshIds)
        .reduce(Long::sum)
        .orElse(0L);

  }

  private static final class Interval implements Comparable<Interval> {
    private Long start;
    private Long end;

    private Interval(Long start, Long end) {
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
    public int compareTo(Interval otherInterval) {
      int startCompare = this.start.compareTo(otherInterval.start);
      if (startCompare == 0) {
        return this.end.compareTo(otherInterval.end);
      }
      return startCompare;
    }
  }
}
