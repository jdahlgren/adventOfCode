package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day7Test {

  @Test
  void part1Example() {
    Day7 day7 = new Day7("example");
    assertThat(day7.numberOfTachyonSplits()).isEqualTo(21);
  }

  @Test
  void part1() {
    Day7 day7 = new Day7("");
    assertThat(day7.numberOfTachyonSplits()).isEqualTo(1640);
  }

}