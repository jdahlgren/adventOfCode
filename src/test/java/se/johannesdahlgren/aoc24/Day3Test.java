package se.johannesdahlgren.aoc24;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;

class Day3Test {

  @Test
  void part1() throws IOException {
    String input = Files.readString(Path.of("src/main/resources/2024/day3"));
    int result = Day3.findAndSumMultiplications(input);
    assertThat(result).isEqualTo(185797128);
  }

  @Test
  void part2() throws IOException {
    String input = Files.readString(Path.of("src/main/resources/2024/day3"));
    int result = Day3.findAndSumMultiplicationsWithReset(input);
    assertThat(result).isEqualTo(89798695);
  }
}