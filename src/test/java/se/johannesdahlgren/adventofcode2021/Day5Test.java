package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day5Test {

  @Test
  void part1Example() {
    Day5 day5 = new Day5("day5example.txt");
    var overlap = day5.getNumberOfPointsWithOverlap(2);
    assertThat(overlap).isEqualTo(5L);
  }

  @Test
  void part1() {
    Day5 day5 = new Day5("day5.txt");
    var overlap = day5.getNumberOfPointsWithOverlap(2);
    assertThat(overlap).isEqualTo(6572L);
  }

  @Test
  void part2Example() {
    Day5 day5 = new Day5("day5example.txt");
    var overlap = day5.getNumberOfPointsWithOverlapWithDiagonalLines(2);
    assertThat(overlap).isEqualTo(12L);
  }

  @Test
  void part2() {
    Day5 day5 = new Day5("day5.txt");
    var overlap = day5.getNumberOfPointsWithOverlapWithDiagonalLines(2);
    assertThat(overlap).isEqualTo(21466L);
  }
}