package se.johannesdahlgren.adventofcode2019;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.johannesdahlgren.adventofcode2019.asserts.AdjacentDigitsAssert;
import se.johannesdahlgren.adventofcode2019.asserts.NeverDecreasesAssert;

class Day4Test {

  private Day4 day4;
  private final int minValue = 248345;
  private final int maxValue = 746315;

  @BeforeEach
  void setUp() {
    day4 = new Day4(minValue, maxValue);
  }

  @Test
  void atLeastOnePassword() {
    List<Integer> passwords = day4.getPasswords();
    assertThat(passwords).isNotEmpty();
  }

  @Test
  void exactly6Digits() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      assertThat(String.valueOf(password).length()).isEqualTo(6);
    }
  }

  @Test
  void noPasswordsWhenRangeStartsLongerThan6() {
    List<Integer> passwords = new Day4(1111111, 1111113).getPasswords();
    assertThat(passwords).isEmpty();
  }

  @Test
  void noPasswordsWhenRangeEndsShorterThan6() {
    List<Integer> passwords = new Day4(111, 113).getPasswords();
    assertThat(passwords).isEmpty();
  }

  @Test
  void withinRange() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      assertThat(password).isGreaterThan(minValue);
      assertThat(password).isLessThan(maxValue);
    }
  }

  @Test
  void atLeastTwoAdjacentDigits() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      AdjacentDigitsAssert.assertThat(password).containsAtLeastTwoAdjacentDigits();
    }
  }

  @Test
  void neverDecreases() {
    List<Integer> passwords = day4.getPasswords();
    for (Integer password : passwords) {
      NeverDecreasesAssert.assertThat(password).digitsNeverDecreases();
    }
  }

  @Test
  void howManyValidPasswords() {
    List<Integer> passwords = day4.getPasswords();
    assertThat(passwords.size()).isEqualTo(1019);
  }

  @Test
  void example1() {
    int password = 111111;

    AdjacentDigitsAssert.assertThat(password).containsAtLeastTwoAdjacentDigits();
    NeverDecreasesAssert.assertThat(password).digitsNeverDecreases();
  }

  @Test
  void example2() {
    int password = 223450;
    AdjacentDigitsAssert.assertThat(password).containsAtLeastTwoAdjacentDigits();
    NeverDecreasesAssert.assertThat(password).notDigitsNeverDecreases();
  }

  @Test
  void example3() {
    int password = 123789;
    AdjacentDigitsAssert.assertThat(password).notContainsAtLeastTwoAdjacentDigits();
    NeverDecreasesAssert.assertThat(password).digitsNeverDecreases();
  }

}