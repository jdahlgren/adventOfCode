package se.johannesdahlgren.aoc23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day2Test {

  @Test
  void part1Example() {
    Day2 day2 = new Day2("day2example.txt");
    int sum = day2.sumOfPossibleGameId(12, 13, 14);
    assertThat(sum).isEqualTo(8);
  }

  @Test
  void part1() {
    Day2 day2 = new Day2("day2.txt");
    int sum = day2.sumOfPossibleGameId(12, 13, 14);
    assertThat(sum).isEqualTo(2449);
  }

  @Test
  void part2Example() {
    Day2 day2 = new Day2("day2example.txt");
    int sum = day2.sumOfPowerOfMinNumberOfCubes();
    assertThat(sum).isEqualTo(2286);
  }

  @Test
  void part2() {
    Day2 day2 = new Day2("day2.txt");
    int sum = day2.sumOfPowerOfMinNumberOfCubes();
    assertThat(sum).isEqualTo(63981);
  }
}