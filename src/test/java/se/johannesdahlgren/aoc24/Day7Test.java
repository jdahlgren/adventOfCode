package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class Day7Test {

  @Test
  void part1() {
    long part1 = new Day7().sumValidTestNumbers(false);
    assertThat(part1).isEqualTo(1582598718861L);
  }

  @Test
  void part2() {
    long part2 = new Day7().sumValidTestNumbers(true);
    assertThat(part2).isEqualTo(165278151522644L);
  }
}
