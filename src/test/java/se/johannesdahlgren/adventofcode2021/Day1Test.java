package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day1Test {

  @Test
  void day1Part1Example() {
    Day1 day1 = new Day1();
    var result = day1.calculateNumberOfDepthIncreases("day1example.txt");
    assertThat(result).isEqualTo(7);
  }

  @Test
  void day1Part1() {
    Day1 day1 = new Day1();
    var result = day1.calculateNumberOfDepthIncreases("day1");
    assertThat(result).isEqualTo(1581);
  }

  @Test
  void day1Part2Example() {
    Day1 day1 = new Day1();
    var result = day1.calculateNumberOfDepthIncreasesSlidingWindow3("day1example.txt");
    assertThat(result).isEqualTo(5);
  }

  @Test
  void day1Part2() {
    Day1 day1 = new Day1();
    var result = day1.calculateNumberOfDepthIncreasesSlidingWindow3("day1");
    assertThat(result).isEqualTo(1618);
  }

}