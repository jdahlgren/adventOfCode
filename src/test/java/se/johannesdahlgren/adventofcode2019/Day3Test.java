package se.johannesdahlgren.adventofcode2019;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class Day3Test {

  @Test
  void findDistanceToClosestIntersectionExample1() {
    Day3 day3 = new Day3("day3_example1.txt");
    int distance = day3.findDistanceToClosestIntersection();
    assertThat(distance).isEqualTo(6);
  }

  @Test
  void findDistanceToClosestIntersectionExample2() {
    Day3 day3 = new Day3("day3_example2.txt");
    int distance = day3.findDistanceToClosestIntersection();
    assertThat(distance).isEqualTo(159);
  }

  @Test
  void findDistanceToClosestIntersectionExample3() {
    Day3 day3 = new Day3("day3_example3.txt");
    int distance = day3.findDistanceToClosestIntersection();
    assertThat(distance).isEqualTo(135);
  }

  @Test
  void findDistanceToClosestIntersection() {
    Day3 day3 = new Day3("day3.txt");
    int distance = day3.findDistanceToClosestIntersection();
    assertThat(distance).isEqualTo(1064);
  }

  @Test
  void findShortestRouteToIntersectionExample1() {
    Day3 day3 = new Day3("day3_example4.txt");
    int distance = day3.findShortestRouteToIntersection();
    assertThat(distance).isEqualTo(610);
  }

  @Test
  void findShortestRouteToIntersectionExample2() {
    Day3 day3 = new Day3("day3_example5.txt");
    int distance = day3.findShortestRouteToIntersection();
    assertThat(distance).isEqualTo(410);
  }

  @Test
  void findShortestRouteToIntersection() {
    Day3 day3 = new Day3("day3.txt");
    int distance = day3.findShortestRouteToIntersection();
    assertThat(distance).isEqualTo(25676);
  }
}