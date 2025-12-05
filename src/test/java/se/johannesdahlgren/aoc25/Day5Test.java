package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day5Test {
  @Test
  void part1Example() {
    Day5 day5 = new Day5("example");
    assertThat(day5.numberOfFreshIngredients()).isEqualTo(3);
  }

  @Test
  void part1() {
    Day5 day5 = new Day5("");
    assertThat(day5.numberOfFreshIngredients()).isEqualTo(868);
  }
}