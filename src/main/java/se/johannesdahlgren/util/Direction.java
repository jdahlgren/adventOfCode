package se.johannesdahlgren.util;

import java.util.Arrays;

public enum Direction {
  UP("U"),
  DOWN("D"),
  RIGHT("R"),
  LEFT("L"),
  UP_LEFT("UL"),
  UP_RIGHT("UR"),
  DOWN_LEFT("DL"),
  DOWN_RIGHT("DR");

  private final String shortName;

  Direction(String shortName) {
    this.shortName = shortName;
  }

  public static Direction fromShortName(String shortName) {
    return Arrays.stream(Direction.values())
        .filter(d -> d.shortName.equals(shortName))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Not a valid Direction"));
  }
}
