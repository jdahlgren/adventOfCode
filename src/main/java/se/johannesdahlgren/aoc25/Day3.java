package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.List;

public class Day3 {

  private final List<String> batteryBanks;

  public Day3(String fileName) {
    batteryBanks = FileUtil.toLines(FileUtil.getPath("2025", "day3." + fileName));
  }

  public long totalOutputJoltage(int batteriesToTurn) {
    long totalOutputJoltage = 0;
    for (String batteryBank : batteryBanks) {
      StringBuilder sb = new StringBuilder();
      int maxJoltageIndex = -1;

      for (int i = 0; i < batteriesToTurn; i++) {
        int maxJoltage = 0;
        for (int j = maxJoltageIndex + 1; j < batteryBank.length() - batteriesToTurn + 1 + i; j++) {
          int nextJoltage = Character.getNumericValue(batteryBank.charAt(j));
          if (nextJoltage > maxJoltage) {
            maxJoltage = nextJoltage;
            maxJoltageIndex = j;
            if (maxJoltage == 9) {
              break;
            }
          }
        }
        sb.append(maxJoltage);
      }

      totalOutputJoltage += Long.parseLong(sb.toString());
    }
    return totalOutputJoltage;
  }
}
