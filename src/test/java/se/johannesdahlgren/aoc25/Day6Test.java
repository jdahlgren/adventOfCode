package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day6Test {
  @Test
  void part1Example() {
    Day6 day6 = new Day6("example");
    assertThat(day6.grandTotal()).isEqualTo(4277556L);
  }

  @Test
  void part1() {
    Day6 day6 = new Day6("");
    assertThat(day6.grandTotal()).isEqualTo(4648618073226L);
  }

  @Test
  void part2Example() {
    Day6 day6 = new Day6("example");
    assertThat(day6.grandTotalCephalopodMath()).isEqualTo(3263827L);
  }

  @Test
  void part2() {
    Day6 day6 = new Day6("");
    assertThat(day6.grandTotalCephalopodMath()).isEqualTo(7329921182115L);
  }
}