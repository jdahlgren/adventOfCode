package se.johannesdahlgren.adventofcode2021;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day7Test {

  @Test
  void part1Example() {
    Day7 day7 = new Day7("day7example.txt");
    long fuelRequired = day7.cheapestAlign();
    assertThat(fuelRequired).isEqualTo(37L);
  }

  @Test
  void part1() {
    Day7 day7 = new Day7("day7.txt");
    long fuelRequired = day7.cheapestAlign();
    assertThat(fuelRequired).isEqualTo(344138L);
  }

  @Test
  void part2Example() {
    Day7 day7 = new Day7("day7example.txt");
    long fuelRequired = day7.cheapestAlignIncreasingBurnRate();
    assertThat(fuelRequired).isEqualTo(168L);
  }

  @Test
  void part2() {
    Day7 day7 = new Day7("day7.txt");
    long fuelRequired = day7.cheapestAlignIncreasingBurnRate();
    assertThat(fuelRequired).isEqualTo(94862124L);
  }

}