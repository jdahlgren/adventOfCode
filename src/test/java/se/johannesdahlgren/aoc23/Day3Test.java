package se.johannesdahlgren.aoc23;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class Day3Test {

  @Test
  void part1Example() {
    Day3 day3 = new Day3("day3example.txt");
    int sumOfPartNumbers = day3.sumOfPartNumbers();
    assertThat(sumOfPartNumbers).isEqualTo(4361);
  }

  @Test
  void part1Example2() {
    Day3 day3 = new Day3("day3example2.txt");
    int sumOfPartNumbers = day3.sumOfPartNumbers();
    assertThat(sumOfPartNumbers).isEqualTo(40);
  }

  @Test
  void part1Example3() {
    Day3 day3 = new Day3("day3example3.txt");
    int sumOfPartNumbers = day3.sumOfPartNumbers();
    assertThat(sumOfPartNumbers).isEqualTo(413);
  }

  @Test
  void part1Example4() {
    Day3 day3 = new Day3("day3example4.txt");
    int sumOfPartNumbers = day3.sumOfPartNumbers();
    assertThat(sumOfPartNumbers).isEqualTo(925);
  }

  @Test
  @Disabled("Unsolved")
  void part1() {
    Day3 day3 = new Day3("day3.txt");
    int sumOfPartNumbers = day3.sumOfPartNumbers();
    assertThat(sumOfPartNumbers).isEqualTo(0); //WTF?
  }

}
