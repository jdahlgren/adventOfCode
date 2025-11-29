package se.johannesdahlgren.adventofcode2019.asserts;

import org.assertj.core.api.AbstractAssert;
import se.johannesdahlgren.adventofcode2019.util.IntUtil;

public class NeverDecreasesAssert extends AbstractAssert<NeverDecreasesAssert, Integer> {

  public NeverDecreasesAssert(Integer actual) {
    super(actual, NeverDecreasesAssert.class);
  }

  public static NeverDecreasesAssert assertThat(Integer actual) {
    return new NeverDecreasesAssert(actual);
  }

  public NeverDecreasesAssert digitsNeverDecreases() {
    isNotNull();
    if (!IntUtil.digitsNeverDecreases(actual)) {
      failWithMessage("Digits decreases: %s", actual);
    }
    return this;
  }

  public NeverDecreasesAssert notDigitsNeverDecreases() {
    isNotNull();
    if (IntUtil.digitsNeverDecreases(actual)) {
      failWithMessage("Digits never decreases: %s", actual);
    }
    return this;
  }
}
