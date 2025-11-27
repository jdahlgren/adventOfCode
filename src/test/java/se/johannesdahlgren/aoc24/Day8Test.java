package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class Day8Test {

  @Test
  void part1() throws IOException {
    int part1 = new Day8().countAntinodes();
    assertThat(part1).isEqualTo(252);
  }

  @Test
  void part2() throws IOException {
    int part2 = new Day8().countAllPossibleAntinodes();
    assertThat(part2).isEqualTo(839);
  }
}
