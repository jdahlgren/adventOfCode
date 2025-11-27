package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class Day5Test {

  @Test
  void part1() throws IOException {
    Day5 day5 = new Day5();
    day5.loadFromFile("src/main/resources/2024/day5");
    int originalSum = day5.sumMiddleNumbersOfValidLists();
    assertThat(originalSum).isEqualTo(6949);
  }

  @Test
  void part2() throws IOException {
    Day5 day5 = new Day5();
    day5.loadFromFile("src/main/resources/2024/day5");
    int fixedSum = day5.sumMiddleNumbersOfFixedInvalidLists();
    assertThat(fixedSum).isEqualTo(4145);
  }
}
