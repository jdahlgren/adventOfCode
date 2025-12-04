package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

  @Test
  void part1Example() {
    Day4 day4 = new Day4("example");
    assertThat(day4.accessiblePaperRolls().size()).isEqualTo(13);
  }

  @Test
  void part1() {
    Day4 day4 = new Day4("");
    assertThat(day4.accessiblePaperRolls().size()).isEqualTo(1604);
  }

  @Test
  void part2Example() {
    Day4 day4 = new Day4("example");
    assertThat(day4.numberOfRemovablePaperRolls()).isEqualTo(43);
  }

  @Test
  void part2() {
    Day4 day4 = new Day4("");
    assertThat(day4.numberOfRemovablePaperRolls()).isEqualTo(9397);
  }
}