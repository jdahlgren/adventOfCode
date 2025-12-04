package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.Direction;
import se.johannesdahlgren.util.FileUtil;
import se.johannesdahlgren.util.Point;

import java.util.ArrayList;
import java.util.List;

class Day4 {

  private final static char ROLL = '@';
  private final PaperRollLocation[][] paperRollLocations;

  private record PaperRollLocation(char c, Point point) {
    int countAdjacentPaperRolls(PaperRollLocation[][] paperRollLocations) {
      int adjacentPaperRolls = 0;
      for (Direction direction : Direction.values()) {
        Point nextPosition = point.nextPosition(direction);
        if (nextPosition.isInBounds(paperRollLocations.length, paperRollLocations[0].length)) {
          char possiblePaperRoll = paperRollLocations[nextPosition.x()][nextPosition.y()].c();
          if (possiblePaperRoll == ROLL) {
            adjacentPaperRolls++;
          }
        }
      }

      return adjacentPaperRolls;
    }
  }

  Day4(String fileName) {
    List<List<Character>> paperMap = FileUtil.toChar2DList(FileUtil.getPath("2025", "day4." + fileName));
    paperRollLocations = new PaperRollLocation[paperMap.size()][paperMap.getFirst().size()];
    for (int i = 0; i < paperMap.size(); i++) {
      for (int j = 0; j < paperMap.get(i).size(); j++) {
        paperRollLocations[i][j] = new PaperRollLocation(paperMap.get(i).get(j), new Point(i, j));
      }
    }
  }

  List<PaperRollLocation> accessiblePaperRolls() {
    List<PaperRollLocation> accessiblePaperRolls = new ArrayList<>();
    for (PaperRollLocation[] row : paperRollLocations) {
      for (PaperRollLocation paperRollLocation : row) {
        if (paperRollLocation.c() == ROLL) {
          int adjacentPaperRolls = paperRollLocation.countAdjacentPaperRolls(paperRollLocations);
          if (adjacentPaperRolls < 4) {
            accessiblePaperRolls.add(paperRollLocation);
          }
        }
      }
    }
    return accessiblePaperRolls;
  }

  int numberOfRemovablePaperRolls() {
    int removablePaperRolls = 0;
    do {
      List<PaperRollLocation> accessiblePaperRolls = accessiblePaperRolls();
      removePaperRolls(accessiblePaperRolls);
      removablePaperRolls += accessiblePaperRolls.size();
    } while (!accessiblePaperRolls().isEmpty());
    return removablePaperRolls;
  }

  private void removePaperRolls(List<PaperRollLocation> accessiblePaperRolls) {
    for (PaperRollLocation paperRollLocation : accessiblePaperRolls) {
      paperRollLocations[paperRollLocation.point().x()][paperRollLocation.point().y()] = new PaperRollLocation('x', paperRollLocation.point());
    }
  }
}
