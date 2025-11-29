package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day3Test {

  @Test
  void part1Example() {
    Day3 day3 = new Day3("day3example.txt");
    var powerConsumption = day3.getPowerConsumption();
    assertThat(powerConsumption).isEqualTo(198);
  }

  @Test
  void part1() {
    Day3 day3 = new Day3("day3.txt");
    var powerConsumption = day3.getPowerConsumption();
    assertThat(powerConsumption).isEqualTo(2724524);
  }

  @Test
  void part2Example() {
    Day3 day3 = new Day3("day3example.txt");
    var powerConsumption = day3.getLifeSupportRating();
    assertThat(powerConsumption).isEqualTo(230);
  }

  @Test
  void part2() {
    Day3 day3 = new Day3("day3.txt");
    var powerConsumption = day3.getLifeSupportRating();
    assertThat(powerConsumption).isEqualTo(2775870);
  }
}