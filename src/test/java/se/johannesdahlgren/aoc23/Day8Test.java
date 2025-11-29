package se.johannesdahlgren.aoc23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day8Test {

  @Test
  void part1Example() {
    Day8 day8 = new Day8("day8example.txt");
    int numberOfStepsToEnd = day8.numberOfStepsToEnd();
    assertThat(numberOfStepsToEnd).isEqualTo(2);
  }

  @Test
  void part1() {
    Day8 day8 = new Day8("day8.txt");
    int numberOfStepsToEnd = day8.numberOfStepsToEnd();
    assertThat(numberOfStepsToEnd).isEqualTo(16343);
  }

}