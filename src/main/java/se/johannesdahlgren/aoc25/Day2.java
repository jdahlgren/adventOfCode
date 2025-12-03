package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.List;

public class Day2 {

  private final List<String> productIdRanges;

  public Day2(String fileName) {
    productIdRanges = FileUtil.toStringFromCsv(FileUtil.getPath("2025", "day2." + fileName));
  }

  public long sumInvalidIds() {
    long sum = 0;
    for (String productIdRange : productIdRanges) {
      long subSum = 0;
      String[] split = productIdRange.split("-");
      long lower = Long.parseLong(split[0]);
      long upper = Long.parseLong(split[1]);
      for (long i = lower; i <= upper; i++) {
        String id = String.valueOf(i);
        if (hasRepeatingTwiceSequence(id)) {
          subSum += i;
        }
      }
      sum += subSum;
    }
    return sum;
  }

  private boolean hasRepeatingTwiceSequence(String id) {
    return id.substring(0, id.length() / 2).equals(id.substring(id.length() / 2));
  }
}
