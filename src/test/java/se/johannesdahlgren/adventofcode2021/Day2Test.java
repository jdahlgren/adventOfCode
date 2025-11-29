package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day2Test {

  @Test
  void day2Part1Example() {
    Day2 day2 = new Day2();
    var posAndDepth = day2.calculatePosition("day2example.txt");
    assertThat(posAndDepth).isEqualTo(150);
  }

  @Test
  void day2Part1() {
    Day2 day2 = new Day2();
    var posAndDepth = day2.calculatePosition("day2.txt");
    assertThat(posAndDepth).isEqualTo(1938402);
  }

  @Test
  void day2Part2Example() {
    Day2 day2 = new Day2();
    var posAndDepth = day2.calculatePositionWithAim("day2example.txt");
    assertThat(posAndDepth).isEqualTo(900);
  }

  @Test
  void day2Part2() {
    Day2 day2 = new Day2();
    var posAndDepth = day2.calculatePositionWithAim("day2.txt");
    assertThat(posAndDepth).isEqualTo(1947878632);
  }

}