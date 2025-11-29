package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day8Test {

  @Test
  void part1Example() {
    Day8 day8 = new Day8("day8example.txt");
    int number = day8.getNumberOfTimesEasyNumbersAppear();
    assertThat(number).isEqualTo(26);
  }

  @Test
  void part1() {
    Day8 day8 = new Day8("day8.txt");
    int number = day8.getNumberOfTimesEasyNumbersAppear();
    assertThat(number).isEqualTo(397);
  }

  @Test
  void part2Example() {
    Day8 day8 = new Day8("day8example2.txt");
    int number = day8.getNumberOutput();
    assertThat(number).isEqualTo(5353);
  }

  @Test
  void part2Example2() {
    Day8 day8 = new Day8("day8example.txt");
    int number = day8.getNumberOutput();
    assertThat(number).isEqualTo(61229);
  }

  @Test
  void part2() {
    Day8 day8 = new Day8("day8.txt");
    int number = day8.getNumberOutput();
    assertThat(number).isEqualTo(1027422);
  }
}