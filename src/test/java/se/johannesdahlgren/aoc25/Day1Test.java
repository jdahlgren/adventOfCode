package se.johannesdahlgren.aoc25;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day1Test {

  @Test
  void day1Part1Example() {
    Day1 day1 = new Day1(".example");
    int actualPassword = day1.actualPassword();
    assertThat(actualPassword).isEqualTo(3);
  }

  @Test
  void day1Part1() {
    Day1 day1 = new Day1("");
    int actualPassword = day1.actualPassword();
    assertThat(actualPassword).isEqualTo(1011);
  }
}