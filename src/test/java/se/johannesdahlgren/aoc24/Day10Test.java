package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class Day10Test {

  @Test
  void part1() throws IOException {
    Day10 solver = new Day10("src/main/resources/2024/day10");
    assertThat(solver.solve().getNumberOfReachableNines()).isEqualTo(593);
  }

  @Test
  void part2() throws IOException {
    Day10 solver = new Day10("src/main/resources/2024/day10");
    assertThat(solver.solve().totalDistinctPaths).isEqualTo(1192);
  }
}
