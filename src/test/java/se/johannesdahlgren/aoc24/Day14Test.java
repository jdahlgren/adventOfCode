package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class Day14Test {

  @Test
  void part1() throws Exception {
    long result = new Day14().safetyFactor(100);
    assertThat(result).isEqualTo(230435667L);
  }

  @Disabled("Slow, around 10 seconds")
  @Test
  void part2() throws Exception {
    long result = new Day14().safetyFactor(10000);
    assertThat(result).isEqualTo(7709L);
  }
}
