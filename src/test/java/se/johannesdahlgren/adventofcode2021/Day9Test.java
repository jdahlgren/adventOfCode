package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day9Test {

  @Test
  void part1Example() {
    Day9 day9 = new Day9("day9example.txt");
    var riskLevel = day9.getRiskLevelsSum();
    assertThat(riskLevel).isEqualTo(15L);
  }

  @Test
  void part1() {
    Day9 day9 = new Day9("day9.txt");
    var riskLevel = day9.getRiskLevelsSum();
    assertThat(riskLevel).isEqualTo(468L);
  }

  @Test
  void part2Example() {
    Day9 day9 = new Day9("day9example.txt");
    var riskLevel = day9.getBasinSizes();
    assertThat(riskLevel).isEqualTo(1134L);
  }

  @Test
  void part2() {
    Day9 day9 = new Day9("day9.txt");
    var riskLevel = day9.getBasinSizes();
    assertThat(riskLevel).isEqualTo(1280496L);
  }

}