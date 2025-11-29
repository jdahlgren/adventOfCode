package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day12Test {

  @Test
  void part1Example1() {
    Day12 day12 = new Day12("day12Example.txt");
    int paths = day12.countPaths();
    assertThat(paths).isEqualTo(10);
  }

  @Test
  void part1Example2() {
    Day12 day12 = new Day12("day12Example2.txt");
    int paths = day12.countPaths();
    assertThat(paths).isEqualTo(19);
  }

  @Test
  void part1Example3() {
    Day12 day12 = new Day12("day12Example3.txt");
    int paths = day12.countPaths();
    assertThat(paths).isEqualTo(226);
  }

  @Test
  void part1() {
    Day12 day12 = new Day12("day12.txt");
    int paths = day12.countPaths();
    assertThat(paths).isEqualTo(5212);
  }
}