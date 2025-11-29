package se.johannesdahlgren.aoc23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day4Test {

  @Test
  void part1Example() {
    Day4 day4 = new Day4("day4example.txt");
    int points = day4.pointsOfWinningNumbers();
    assertThat(points).isEqualTo(13);
  }

  @Test
  void part1() {
    Day4 day4 = new Day4("day4.txt");
    int points = day4.pointsOfWinningNumbers();
    assertThat(points).isEqualTo(23235);
  }


  @Test
  void part2Example() {
    Day4 day4 = new Day4("day4example.txt");
    int numberOfScratchCards = day4.numberOfScratchCards();
    assertThat(numberOfScratchCards).isEqualTo(30);
  }

  @Disabled("Slow, around 10 seconds")
  @Test
  void part2() {
    Day4 day4 = new Day4("day4.txt");
    int numberOfScratchCards = day4.numberOfScratchCards();
    assertThat(numberOfScratchCards).isEqualTo(5920640);
  }
}