package se.johannesdahlgren.adventofcode2019;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day1Test {

  private Day1 day1;

  @BeforeEach
  void setUp() {
    day1 = new Day1();
  }

  @Test
  void requiredFuelForModule1() {
    String filePath = "day1_example1.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel).isEqualTo(2);
  }

  @Test
  void requiredFuelForModule2() {
    String filePath = "day1_example2.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel).isEqualTo(2);
  }

  @Test
  void requiredFuelForModule3() {
    String filePath = "day1_example3.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel).isEqualTo(654);
  }

  @Test
  void requiredFuelForModule4() {
    String filePath = "day1_example4.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel).isEqualTo(33583);
  }

  @Test
  void requiredFuelForAllModules() {
    String filePath = "day1_examples.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel).isEqualTo(2 + 2 + 654 + 33583);
  }

  @Test
  void requiredFuelForAllModulesWithExampleInput() {
    String filePath = "day1_examples.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel).isEqualTo(2 + 2 + 654 + 33583);
  }

  @Test
  void requiredFuelForAllModulesWithRealInput() {
    String filePath = "day1.txt";
    int requiredFuel = day1.calculateRequiredFuelForMass(filePath);
    assertThat(requiredFuel).isEqualTo(3342946);
  }

  @Test
  void requiredFuelForModule2AndItsOwnFuel() {
    String filePath = "day1_example2.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel).isEqualTo(2);
  }

  @Test
  void requiredFuelForModule3AndItsOwnFuel() {
    String filePath = "day1_example3.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel).isEqualTo(966);
  }

  @Test
  void requiredFuelForModule4AndItsOwnFuel() {
    String filePath = "day1_example4.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel).isEqualTo(50346);
  }

  @Test
  void requiredFuelForAllModulesAndItsOwnFuelWithExampleInput() {
    String filePath = "day1_examples.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel).isEqualTo(2 + 2 + 966 + 50346);
  }

  @Test
  void requiredFuelForAllModulesAndItsOwnFuelWithRealInput() {
    String filePath = "day1.txt";
    int requiredFuel = day1.calculateRequiredFuelForMassOfModuleAndItsFuel(filePath);
    assertThat(requiredFuel).isEqualTo(5011553);
  }
}