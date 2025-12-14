package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day8Test {
  @Test
  void part1Example() {
    Day8 day8 = new Day8(".example");
    assertThat(day8.threeLargestCircuits(10)).isEqualTo(40);
  }

  @Test
  void part1() {
    Day8 day8 = new Day8("");
    assertThat(day8.threeLargestCircuits(1000)).isEqualTo(105952);
  }

  @Test
  void part2Example() {
    Day8 day8 = new Day8(".example");
    assertThat(day8.connectAll()).isEqualTo(25272);
  }

  @Disabled("Slow, around 10 seconds")
  @Test
  void part2() {
    Day8 day8 = new Day8("");
    assertThat(day8.connectAll()).isEqualTo(975931446);
  }
}