package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.List;

public class Day3 {

  private final List<String> batteryBanks;

  public Day3(String fileName) {
    batteryBanks = FileUtil.toLines(FileUtil.getPath("2025", "day3." + fileName));
  }

  public int totalOutputJoltage() {
    int totalOutputJoltage = 0;
    for (String batteryBank : batteryBanks) {
      int maxJoltage = 0;
      int maxJoltageIndex = -1;
      for (int i = 0; i < batteryBank.length() - 1; i++) {
        int nextJoltage = Character.getNumericValue(batteryBank.charAt(i));
        if (nextJoltage > maxJoltage) {
          maxJoltage = nextJoltage;
          maxJoltageIndex = i;
          if (maxJoltage == 9) {
            break;
          }
        }
      }
      int secondMaxJoltage = 0;
      for (int i = maxJoltageIndex + 1; i < batteryBank.length(); i++) {
        int nextJoltage = Character.getNumericValue(batteryBank.charAt(i));
        if (nextJoltage > secondMaxJoltage) {
          secondMaxJoltage = nextJoltage;
          if (secondMaxJoltage == 9) {
            break;
          }
        }
      }
      totalOutputJoltage += Integer.parseInt("" + maxJoltage + secondMaxJoltage);
    }
    return totalOutputJoltage;
  }
}
