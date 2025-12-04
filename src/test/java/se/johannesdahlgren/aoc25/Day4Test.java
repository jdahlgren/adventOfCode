package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

  @Test
  void part1Example() {
    Day4 day4 = new Day4("example");
    assertThat(day4.numberOfAccessiblePaperRolls()).isEqualTo(13);
  }

  @Test
  void part1() {
    Day4 day4 = new Day4("");
    assertThat(day4.numberOfAccessiblePaperRolls()).isEqualTo(1604);
  }
}