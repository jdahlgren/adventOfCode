package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day10Test {

  @Test
  void part1Example() {
    Day10 day10 = new Day10("day10Example.txt");
    long syntaxErrorScore = day10.calculateSyntaxErrorScore();
    assertThat(syntaxErrorScore).isEqualTo(26397L);
  }

  @Test
  void part1() {
    Day10 day10 = new Day10("day10.txt");
    long syntaxErrorScore = day10.calculateSyntaxErrorScore();
    assertThat(syntaxErrorScore).isEqualTo(290691L);
  }

  @Test
  void part2Example() {
    Day10 day10 = new Day10("day10Example.txt");
    long syntaxErrorScore = day10.calculateAutoCompleteScore();
    assertThat(syntaxErrorScore).isEqualTo(288957L);
  }

  @Test
  void part2() {
    Day10 day10 = new Day10("day10.txt");
    long syntaxErrorScore = day10.calculateAutoCompleteScore();
    assertThat(syntaxErrorScore).isEqualTo(2768166558L);
  }
}