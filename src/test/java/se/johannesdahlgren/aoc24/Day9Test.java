package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Day9Test {

  @Test
  void part1() throws IOException {
    Day9 day9 = new Day9();
    List<Integer> integers = day9.moveNumbersToSpaces();
    long sum = day9.calculateSum(integers);

    assertThat(sum).isEqualTo(6384282079460L);
  }

  @Test
  void part2() throws IOException {
    Day9 day9 = new Day9();
    List<Integer> integers = day9.moveGroupsToSpaces();
    long sum = day9.calculateSum(integers);

    assertThat(sum).isEqualTo(6408966547049L);
  }
}
