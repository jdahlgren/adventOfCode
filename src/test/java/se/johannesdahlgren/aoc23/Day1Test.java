package se.johannesdahlgren.aoc23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day1Test {

  @Test
  void day1Part1Example() {
    Day1 day1 = new Day1();
    int sumOfCalibrationValues = day1.sumOfCalibrationValues("day1example.txt");
    assertThat(sumOfCalibrationValues).isEqualTo(142);
  }

  @Test
  void day1Part1() {
    Day1 day1 = new Day1();
    int sumOfCalibrationValues = day1.sumOfCalibrationValues("day1.txt");
    assertThat(sumOfCalibrationValues).isEqualTo(55208);
  }

  @Test
  void day1Part2Example() {
    Day1 day1 = new Day1();
    int sumOfCalibrationValues = day1.sumOfCalibrationValuesWithWords("day1example2.txt");
    assertThat(sumOfCalibrationValues).isEqualTo(281);
  }

  @Test
  void day1Part2() {
    Day1 day1 = new Day1();
    int sumOfCalibrationValues = day1.sumOfCalibrationValuesWithWords("day1.txt");
    assertThat(sumOfCalibrationValues).isEqualTo(54578);
  }
}