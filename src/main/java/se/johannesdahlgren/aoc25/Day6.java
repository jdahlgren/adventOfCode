package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static se.johannesdahlgren.util.FileUtil.getPath;

public class Day6 {

  private final String[][] numbers;
  private final String[] operations;
  private final List<List<Character>> worksheet2;

  public Day6(String fileName) {
    List<String> worksheet = FileUtil.toLines(getPath("2025", "day6." + fileName));
    worksheet2 = FileUtil.toChar2DList(getPath("2025", "day6." + fileName));
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

  public long grandTotalCephalopodMath() {
    List<CephalopodWorksheet> worksheets = getCephalopodWorksheets();

    long grandTotal = 0L;
    for (CephalopodWorksheet cephalopodWorksheet : worksheets) {
      if (cephalopodWorksheet.operator.equals('*')) {
        grandTotal += cephalopodWorksheet.numbers().stream().reduce(1L, (a, b) -> a * b);
      } else if (cephalopodWorksheet.operator.equals('+')) {
        grandTotal += cephalopodWorksheet.numbers().stream().reduce(0L, Long::sum);
      }
    }

    return grandTotal;
  }

  private List<CephalopodWorksheet> getCephalopodWorksheets() {
    List<Long> correct = new ArrayList<>();
    ArrayList<List<Character>> temp = new ArrayList<>(worksheet2);
    List<Character> operations = temp.removeLast();
    List<CephalopodWorksheet> worksheets = new ArrayList<>();
    for (int j = temp.getFirst().size() - 1; j >= 0; j--) {
      StringBuilder t = new StringBuilder();
      for (List<Character> characters : temp) {
        Character c = characters.get(j);
        if (c != 32) {
          t.append(c);
        }
      }
      if (!t.isEmpty()) {
        correct.add(Long.parseLong(t.toString()));
      } else {
        worksheets.add(new CephalopodWorksheet(operations.get(j + 1), correct.stream().toList()));
        correct.clear();
      }
    }
    worksheets.add(new CephalopodWorksheet(operations.getFirst(), correct.stream().toList()));
    return worksheets;
  }

  private record CephalopodWorksheet(Character operator, List<Long> numbers) {

  }
}
