package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day6Test {

  @Test
  void part1Example1() {
    Day6 day6 = new Day6("day6example.txt");
    long numberOfLanternFishAfterDays = day6.spawnLanternFishSmarter(18);
    assertThat(numberOfLanternFishAfterDays).isEqualTo(26L);
  }

  @Test
  void part1Example2() {
    Day6 day6 = new Day6("day6example.txt");
    long numberOfLanternFishAfterDays = day6.spawnLanternFishSmarter(80);
    assertThat(numberOfLanternFishAfterDays).isEqualTo(5934L);
  }

  @Test
  void part1() {
    Day6 day6 = new Day6("day6.txt");
    long numberOfLanternFishAfterDays = day6.spawnLanternFishSmarter(80);
    assertThat(numberOfLanternFishAfterDays).isEqualTo(373378L);
  }

  @Test
  void part2example() {
    Day6 day6 = new Day6("day6example.txt");
    long numberOfLanternFishAfterDays = day6.spawnLanternFishSmarter(256);
    assertThat(numberOfLanternFishAfterDays).isEqualTo(26984457539L);
  }

  @Test
  void part2() {
    Day6 day6 = new Day6("day6.txt");
    long numberOfLanternFishAfterDays = day6.spawnLanternFishSmarter(256);
    assertThat(numberOfLanternFishAfterDays).isEqualTo(1682576647495L);
  }

}