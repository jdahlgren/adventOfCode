package se.johannesdahlgren.aoc25;

import java.util.List;
import java.util.stream.IntStream;
import se.johannesdahlgren.util.FileUtil;

public class Day1 {

  private final List<String> lines;
  private final int[] lockDial = IntStream.range(0, 100).toArray();
  private int currentPosition = 50;
  private int numberOfTimesAtZero = 0;

  public Day1(String fileName) {
    lines = FileUtil.toLines(FileUtil.getPath("2025", "day1" + fileName));
  }

  public int actualPassword() {
    for (String line : lines) {
      String direction = line.substring(0, 1);
      int steps = Integer.parseInt(line.substring(1));
      if (direction.equals("R")) {
        currentPosition = Math.floorMod(currentPosition + steps, lockDial.length);
      } else {
        currentPosition = Math.floorMod(currentPosition - steps, lockDial.length);
      }
      if (currentPosition == 0) {
        numberOfTimesAtZero++;
      }
    }
    return numberOfTimesAtZero;
  }

  public int method0x434C49434B() {
    for (String line : lines) {
      String direction = line.substring(0, 1);
      int steps = Integer.parseInt(line.substring(1));

      if (direction.equals("R")) {
        int nextPos = currentPosition + steps;
        numberOfTimesAtZero += nextPos / lockDial.length;
        currentPosition = Math.floorMod(nextPos, lockDial.length);
      } else {
        int nextPos = currentPosition - steps;
        if (currentPosition != 0 && nextPos <= 0) {
          numberOfTimesAtZero++;
        }
        numberOfTimesAtZero += Math.abs(nextPos) / lockDial.length;
        currentPosition = Math.floorMod(nextPos, lockDial.length);
      }
    }
    return numberOfTimesAtZero;
  }
}
