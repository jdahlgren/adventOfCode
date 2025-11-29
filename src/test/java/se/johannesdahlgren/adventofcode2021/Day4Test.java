package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class Day4Test {

  @Test
  void part1Example() {
   Day4 day4 = new Day4("day4example.txt");
   var score = day4.playBingo();
   assertThat(score).isEqualTo(4512);
  }

  @Test
  void part1() {
    Day4 day4 = new Day4("day4.txt");
    var score = day4.playBingo();
    assertThat(score).isEqualTo(44736);
  }

  @Test
  void part2Example() {
    Day4 day4 = new Day4("day4example.txt");
    var score = day4.playBingoLastWinningBoard();
    assertThat(score).isEqualTo(1924);
  }

  @Test
  void part2() {
    Day4 day4 = new Day4("day4.txt");
    var score = day4.playBingoLastWinningBoard();
    assertThat(score).isEqualTo(1827);
  }
}