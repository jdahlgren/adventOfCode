package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {

  @Test
  void part1Example() {
    Day3 day3 = new Day3("example");
    assertThat(day3.totalOutputJoltage()).isEqualTo(357);
  }

  @Test
  void part1() {
    Day3 day3 = new Day3("");
    assertThat(day3.totalOutputJoltage()).isEqualTo(17524);
  }
}