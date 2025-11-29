package se.johannesdahlgren.adventofcode2019;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day5Test {

  private Day5 day5;

  @Test
  void part1() {
    day5 = new Day5("day5.txt", 1);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(10987514);
  }

  @Test
  void runDiagnosticCodeExample1() {
    int input = 9;
    day5 = new Day5("day5_example1.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(input);
  }

  @Test
  void runDiagnosticCodeExample2EqualsEight() {
    int input = 8;
    day5 = new Day5("day5_example2.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1);
  }

  @Test
  void runDiagnosticCodeExample2NotEqualsEight() {
    int input = 9;
    day5 = new Day5("day5_example2.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(0);
  }

  @Test
  void runDiagnosticCodeExample3LTEight() {
    int input = 2;
    day5 = new Day5("day5_example3.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1);
  }

  @Test
  void runDiagnosticCodeExample3NotLTEight() {
    int input = 9;
    day5 = new Day5("day5_example3.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(0);
  }

  @Test
  void runDiagnosticCodeExample4EqualsEight() {
    int input = 8;
    day5 = new Day5("day5_example4.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1);
  }

  @Test
  void runDiagnosticCodeExample4NotEqualsEight() {
    int input = 9;
    day5 = new Day5("day5_example4.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(0);
  }

  @Test
  void runDiagnosticCodeExample5LTEight() {
    int input = 2;
    day5 = new Day5("day5_example5.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1);
  }

  @Test
  void runDiagnosticCodeExample5NotLTEight() {
    int input = 9;
    day5 = new Day5("day5_example5.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(0);
  }

  @Test
  void runDiagnosticCodeExample6ZeroInput() {
    int input = 0;
    day5 = new Day5("day5_example6.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(0);
  }

  @Test
  void runDiagnosticCodeExample6NonZeroInput() {
    int input = 2;
    day5 = new Day5("day5_example6.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1);
  }

  @Test
  void runDiagnosticCodeExample7ZeroInput() {
    int input = 0;
    day5 = new Day5("day5_example7.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(0);
  }

  @Test
  void runDiagnosticCodeExample7NonZeroInput() {
    int input = 9;
    day5 = new Day5("day5_example7.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1);
  }

  @Test
  void runDiagnosticCodeExample8LTEight() {
    int input = 7;
    day5 = new Day5("day5_example8.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(999);
  }

  @Test
  void runDiagnosticCodeExample8EqEight() {
    int input = 8;
    day5 = new Day5("day5_example8.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1000);
  }

  @Test
  void runDiagnosticCodeExample8GTEight() {
    int input = 9;
    day5 = new Day5("day5_example8.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(1001);
  }

  @Test
  void part2() {
    int input = 5;
    day5 = new Day5("day5.txt", input);
    int integers = day5.runDiagnosticCode();
    assertThat(integers).isEqualTo(14195011);
  }

}