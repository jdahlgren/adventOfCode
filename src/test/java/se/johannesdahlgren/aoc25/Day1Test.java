package se.johannesdahlgren.aoc25;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day1Test {

  @Test
  void part1Example() {
    Day1 day1 = new Day1(".example");
    int actualPassword = day1.actualPassword();
    assertThat(actualPassword).isEqualTo(3);
  }

  @Test
  void part1() {
    Day1 day1 = new Day1("");
    int actualPassword = day1.actualPassword();
    assertThat(actualPassword).isEqualTo(1011);
  }

  @Test
  void part2Example() {
    Day1 day1 = new Day1(".example");
    int actualPassword = day1.method0x434C49434B();
    assertThat(actualPassword).isEqualTo(6);
  }

  @Test
  void part2() {
    Day1 day1 = new Day1("");
    int actualPassword = day1.method0x434C49434B();
    assertThat(actualPassword).isEqualTo(5937);
  }
}