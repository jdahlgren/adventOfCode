package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class Day12Test {

  @Test
  void part1() {
    long count = new Day12().solve();
    assertThat(count).isEqualTo(1402544L);
  }

}
