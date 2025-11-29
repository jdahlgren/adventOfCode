package se.johannesdahlgren.adventofcode2019;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class Day7Test {

  @Test
  void example1() {
    Day7 day7 = new Day7("day7_example1");
    int maxThrusterSignal = day7.tryThrusterSignal(List.of(4, 3, 2, 1, 0));
    assertThat(maxThrusterSignal).isEqualTo(43210);
  }

  @Test
  void example2() {
    Day7 day7 = new Day7("day7_example2");
    int maxThrusterSignal = day7.tryThrusterSignal(List.of(0, 1, 2, 3, 4));
    assertThat(maxThrusterSignal).isEqualTo(54321);
  }

  @Test
  void example3() {
    Day7 day7 = new Day7("day7_example3");
    int maxThrusterSignal = day7.tryThrusterSignal(List.of(1, 0, 4, 3, 2));
    assertThat(maxThrusterSignal).isEqualTo(65210);
  }

  @Test
  void part1() {
    Day7 day7 = new Day7("day7");
    int maxThrusterSignal = day7.findMaxThrusterSignal();
    assertThat(maxThrusterSignal).isEqualTo(101490);
  }
}