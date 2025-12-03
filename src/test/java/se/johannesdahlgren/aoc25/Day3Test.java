package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {

  @Test
  void part1Example() {
    Day3 day3 = new Day3("example");
    assertThat(day3.totalOutputJoltage(2)).isEqualTo(357);
  }

  @Test
  void part1() {
    Day3 day3 = new Day3("");
    assertThat(day3.totalOutputJoltage(2)).isEqualTo(17524);
  }

  @Test
  void part2Example() {
    Day3 day3 = new Day3("example");
    assertThat(day3.totalOutputJoltage(12)).isEqualTo(3121910778619L);
  }

  @Test
  void part2() {
    Day3 day3 = new Day3("");
    assertThat(day3.totalOutputJoltage(12)).isEqualTo(173848577117276L);
  }
}