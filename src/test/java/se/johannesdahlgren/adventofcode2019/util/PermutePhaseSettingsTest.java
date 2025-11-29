package se.johannesdahlgren.adventofcode2019.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class PermutePhaseSettingsTest {

  @Test
  void permute1() {
    PermutePhaseSettings permutePhaseSettings = new PermutePhaseSettings();
    List<List<Integer>> permutations = permutePhaseSettings.permute(List.of(1));
    assertThat(permutations.size()).isEqualTo(1);
    assertThat(permutations.getFirst().size()).isEqualTo(1);
    assertThat(permutations.getFirst().getFirst()).isEqualTo(1);
  }

  @Test
  void permute2() {
    PermutePhaseSettings permutePhaseSettings = new PermutePhaseSettings();
    List<List<Integer>> permutations = permutePhaseSettings.permute(Arrays.asList(1, 2));
    assertThat(permutations.size()).isEqualTo(2);
    assertThat(permutations.get(0).size()).isEqualTo(2);
    assertThat(permutations.get(0)).containsExactly(1,2);
    assertThat(permutations.get(1).size()).isEqualTo(2);
    assertThat(permutations.get(1)).containsExactly(2, 1);
  }
}