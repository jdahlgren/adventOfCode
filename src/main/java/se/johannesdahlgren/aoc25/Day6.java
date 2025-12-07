package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.Arrays;
import java.util.List;

public class Day6 {

  private final String[][] numbers;
  private final String[] operations;

  public Day6(String fileName) {
    List<String> worksheet = FileUtil.toLines(FileUtil.getPath("2025", "day6." + fileName));
    operations = worksheet.removeLast().split("\\s+");
    numbers = new String[worksheet.size()][];
    for (int i = 0; i < worksheet.size(); i++) {
      String line = worksheet.get(i);
      numbers[i] = Arrays.stream(line.split("\\s+"))
          .filter(n -> !n.isEmpty())
          .toArray(String[]::new);
    }
  }

  public long grandTotal() {
    long grandTotal = 0L;
    for (int j = 0; j < numbers[0].length; j++) {
      long subTotal = Long.parseLong(numbers[0][j]);
      for (int i = 1; i < numbers.length; i++) {
        if (operations[j].equals("*")) {
          subTotal *= Long.parseLong(numbers[i][j]);
        } else if (operations[j].equals("+")) {
          subTotal += Long.parseLong(numbers[i][j]);
        }
      }
      grandTotal += subTotal;
    }

    return grandTotal;
  }
}
