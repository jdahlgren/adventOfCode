package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day13Test {

  @Test
  void part1() throws Exception {
    int count = new Day13().solveMachines();
    assertThat(count).isEqualTo(26299);
  }

}
