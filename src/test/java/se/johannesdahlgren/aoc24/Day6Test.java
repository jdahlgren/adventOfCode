package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class Day6Test {

  @Test
  void part1() throws IOException {
    int part1 = new Day6().part1();
    assertThat(part1).isEqualTo(4819);
  }

  @Test
  void part2() throws IOException {
    int part2 = new Day6().part2();
    assertThat(part2).isEqualTo(1796);
  }
}
