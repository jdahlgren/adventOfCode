package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class Day11Test {

  @Test
  void part1() throws Exception {
    long count = new Day11().processInput(25);
    assertThat(count).isEqualTo(186175L);
  }

  @Test
  void part2() throws Exception {
    long count = new Day11().processInput(75);
    assertThat(count).isEqualTo(220566831337810L);
  }
}
