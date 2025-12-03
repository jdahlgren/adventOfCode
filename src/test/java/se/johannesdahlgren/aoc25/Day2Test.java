package se.johannesdahlgren.aoc25;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Day2Test {

  @Test
  void part1Example() {
    Day2 day2 = new Day2("example");
    assertThat(day2.sumInvalidIds()).isEqualTo(1227775554L);
  }

  @Test
  void part1() {
    Day2 day2 = new Day2("");
    assertThat(day2.sumInvalidIds()).isEqualTo(40398804950L);
  }
}