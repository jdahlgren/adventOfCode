package se.johannesdahlgren.aoc23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day5Test {

  @Test
  void part1Example() {
    Day5 day5 = new Day5("day5example.txt");
    long temp = day5.getLowestLocationNumber();
    assertThat(temp).isEqualTo(35L);
  }

  @Test
  void part1() {
    Day5 day5 = new Day5("day5.txt");
    long temp = day5.getLowestLocationNumber();
    assertThat(temp).isEqualTo(486613012L);
  }

  @Test
  void part2Example() {
    Day5 day5 = new Day5("day5example.txt");
    long temp = day5.getLowestLocationNumberRange();
    assertThat(temp).isEqualTo(46L);
  }

  @Disabled("Slow, around 2.5 minutes")
  @Test
  void part2() {
    Day5 day5 = new Day5("day5.txt");
    long temp = day5.getLowestLocationNumberRange();
    assertThat(temp).isEqualTo(56931769L);
  }
}