package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day20Test {

  @Test
  void part1Example() {
    Day20 day20 = new Day20("day20Example.txt");
    long litPixels = day20.enhanceTrenchMap(2);
    assertThat(litPixels).isEqualTo(35L);
  }

  @Test
  void part1() {
    Day20 day20 = new Day20("day20.txt");
    long litPixels = day20.enhanceTrenchMap(2);
    assertThat(litPixels).isEqualTo(5395L);
  }

  @Test
  void part2Example() {
    Day20 day20 = new Day20("day20Example.txt");
    long litPixels = day20.enhanceTrenchMap(50);
    assertThat(litPixels).isEqualTo(3351L);
  }

  @Test
  void part2() {
    Day20 day20 = new Day20("day20.txt");
    long litPixels = day20.enhanceTrenchMap(50);
    assertThat(litPixels).isEqualTo(17584L);
  }

}