package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.List;
import java.util.stream.IntStream;

public class Day2 {

  private final List<String> productIdRanges;

  public Day2(String fileName) {
    productIdRanges = FileUtil.toStringFromCsv(FileUtil.getPath("2025", "day2." + fileName));
  }

  public long sumInvalidIds(boolean atLeastTwice) {
    long sum = 0;
    for (String productIdRange : productIdRanges) {
      long subSum = 0;
      String[] split = productIdRange.split("-");
      long lower = Long.parseLong(split[0]);
      long upper = Long.parseLong(split[1]);
      for (long i = lower; i <= upper; i++) {
        String id = String.valueOf(i);
        if (hasRepeatingTwiceSequence(id) || (atLeastTwice && hasRepeatingSequence(id))) {
          subSum += i;
        }
      }
      sum += subSum;
    }
    return sum;
  }

  private boolean hasRepeatingSequence(String id) {
    for (int i = 1; i <= id.length() / 2; i++) {
      int finalI = i;
      int start = 0;
      int end = (id.length() + i - 1) / i;
      List<String> list = IntStream
          .range(start, end)
          .mapToObj(j -> id.substring(j * finalI, Math.min((j + 1) * finalI, id.length())))
          .toList();

      if (list.size() >= 2 & list.stream().allMatch(s -> list.getFirst().equals(s))) {
        return true;
      }
    }
    return false;
  }

  private boolean hasRepeatingTwiceSequence(String id) {
    return id.substring(0, id.length() / 2).equals(id.substring(id.length() / 2));
  }
}
