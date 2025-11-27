package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day4Test {

  @Test
  void part1() {
    int xmas = new Day4().findXMAS();
    assertThat(xmas).isEqualTo(2718);
  }

  @Test
  void part2() {
    int xmas = new Day4().findMASCross();
    assertThat(xmas).isEqualTo(2046);
  }
}
