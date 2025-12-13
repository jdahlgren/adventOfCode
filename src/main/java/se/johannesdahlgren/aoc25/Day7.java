package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.Direction;
import se.johannesdahlgren.util.FileUtil;
import se.johannesdahlgren.util.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static se.johannesdahlgren.util.FileUtil.getPath;

public class Day7 {

  private final List<List<Character>> tachyonManifold;

  public Day7(String fileName) {
    tachyonManifold = FileUtil.toChar2DList(getPath("2025", "day7." + fileName));
  }

  public int numberOfTachyonSplits() {
    int numberOfTachyonSplits = 0;
    Set<Point> beams = new HashSet<>();
    beams.add(getStartBeam());
    for (int i = 0; i < tachyonManifold.size() - 1; i++) {
      numberOfTachyonSplits += moveBeam(beams);
    }

    return numberOfTachyonSplits;
  }

  private int moveBeam(Set<Point> beams) {
    int numberOfSplits = 0;
    for (Point beam : new HashSet<>(beams)) {
      Point point = beam.nextPosition(Direction.RIGHT);
      if (tachyonManifold.get(point.x()).get(point.y()) == '^') {
        beams.remove(beam);
        beams.add(point.nextPosition(Direction.UP));
        beams.add(point.nextPosition(Direction.DOWN));
        numberOfSplits++;
      } else {
        beams.remove(beam);
        beams.add(point);
      }
    }
    return numberOfSplits;
  }

  private Point getStartBeam() {
    for (int i = 0; i < tachyonManifold.size(); i++) {
      for (int j = 0; j < tachyonManifold.get(i).size(); j++) {
        if (tachyonManifold.get(i).get(j) == 'S') {
          return new Point(i, j);
        }
      }
    }
    return null;
  }
}
