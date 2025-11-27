package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;

class Day2Test {

  @Test
  void part1() throws IOException {
    int result = new Day2().part1();
    assertThat(result).isEqualTo(564);
  }

  @Test
  void part2() throws IOException {
    int result = new Day2().part2();
    assertThat(result).isEqualTo(604);
  }
}