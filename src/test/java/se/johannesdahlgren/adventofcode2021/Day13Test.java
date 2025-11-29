package se.johannesdahlgren.adventofcode2021;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day13Test {

  @Test
  void part1Example() {
    Day13 day13 = new Day13("day13Example.txt");
    long dotsAfterFold = day13.foldOnce();
    assertThat(dotsAfterFold).isEqualTo(17L);
  }

  @Test
  void part1() {
    Day13 day13 = new Day13("day13.txt");
    long dotsAfterFold = day13.foldOnce();
    assertThat(dotsAfterFold).isEqualTo(781L);
  }

  @Test
  void part2Example() {
    Day13 day13 = new Day13("day13Example.txt");
    String code = day13.foldAll();
    String expectedNumber = """
        #####
        #   #
        #   #
        #   #
        #####
        """;
    assertThat(code).isEqualTo(expectedNumber);
  }

  @Test
  void part2() {
    Day13 day13 = new Day13("day13.txt");
    String code = day13.foldAll();
    String expectedNumber = """
        ###  #### ###   ##   ##    ## ###  ###\s
        #  # #    #  # #  # #  #    # #  # #  #
        #  # ###  #  # #    #       # #  # ###\s
        ###  #    ###  #    # ##    # ###  #  #
        #    #    # #  #  # #  # #  # #    #  #
        #    #### #  #  ##   ###  ##  #    ###\s
        """;
    assertThat(code).isEqualTo(expectedNumber);
  }
}