package se.johannesdahlgren.adventofcode2019.asserts;

import org.assertj.core.api.AbstractAssert;
import se.johannesdahlgren.adventofcode2019.util.IntUtil;

public class AdjacentDigitsAssert extends AbstractAssert<AdjacentDigitsAssert, Integer> {

  public AdjacentDigitsAssert(Integer integer) {
    super(integer, AdjacentDigitsAssert.class);
  }

  public static AdjacentDigitsAssert assertThat(Integer actual) {
    return new AdjacentDigitsAssert(actual);
  }

  public AdjacentDigitsAssert containsAtLeastTwoAdjacentDigits() {
    isNotNull();
    if (!IntUtil.containsAdjacentDigits(actual)) {
      failWithMessage("At no adjacent digits, %s", actual);
    }
    return this;
  }

  public AdjacentDigitsAssert notContainsAtLeastTwoAdjacentDigits() {
    isNotNull();
    if (IntUtil.containsAdjacentDigits(actual)) {
      failWithMessage("At least two adjacent digits, %s", actual);
    }
    return this;
  }
}
