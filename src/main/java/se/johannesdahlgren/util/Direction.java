package se.johannesdahlgren.util;

import java.util.Arrays;
import java.util.List;

public enum Direction {
  UP("U"),
  DOWN("D"),
  RIGHT("R"),
  LEFT("L"),
  UP_LEFT("UL"),
  UP_RIGHT("UR"),
  DOWN_LEFT("DL"),
  DOWN_RIGHT("DR");

  public static final List<Direction> NON_DIAGONAL_DIRECTIONS = List.of(UP, DOWN, RIGHT, LEFT);

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

  public Direction turn90DegreesClockwise() {
    return switch (this) {
      case UP -> RIGHT;
      case RIGHT -> DOWN;
      case DOWN -> LEFT;
      case LEFT -> UP;
      case UP_LEFT -> UP_RIGHT;
      case UP_RIGHT -> DOWN_RIGHT;
      case DOWN_RIGHT -> DOWN_LEFT;
      case DOWN_LEFT -> UP_LEFT;
    };
  }
}
