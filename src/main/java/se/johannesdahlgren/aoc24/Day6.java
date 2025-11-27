package se.johannesdahlgren.aoc24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import se.johannesdahlgren.util.Point;

public class Day6 {
  private enum Direction {
    NORTH(0, -1),
    EAST(1, 0),
    SOUTH(0, 1),
    WEST(-1, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
      this.dx = dx;
      this.dy = dy;
    }

    public Direction turnRight() {
      return switch (this) {
        case NORTH -> EAST;
        case EAST -> SOUTH;
        case SOUTH -> WEST;
        case WEST -> NORTH;
      };
    }
  }

  private record State(Point position, Direction direction) {}

  public int part1() throws IOException {
    List<String> lines = Files.readAllLines(Path.of("src/main/resources/2024/day6"));
    char[][] map = createMap(lines);
    Point startPos = findStartPosition(map);
    return simulateGuard(map, startPos).visitedPositions().size();
  }

  public int part2() throws IOException {
    List<String> lines = Files.readAllLines(Path.of("src/main/resources/2024/day6"));
    char[][] originalMap = createMap(lines);
    Point startPos = findStartPosition(originalMap);
    int loopCount = 0;

    for (int y = 0; y < originalMap.length; y++) {
      for (int x = 0; x < originalMap[y].length; x++) {
        if (originalMap[y][x] == '#' || (x == startPos.x() && y == startPos.y())) {
          continue;
        }

        char[][] mapCopy = copyMap(originalMap);
        mapCopy[y][x] = '#';

        if (simulateGuard(mapCopy, startPos).isLoop()) {
          loopCount++;
        }
      }
    }

    return loopCount;
  }

  private record SimulationResult(Set<Point> visitedPositions, boolean isLoop) {}

  private SimulationResult simulateGuard(char[][] map, Point startPos) {
    Set<Point> visitedPositions = new HashSet<>();
    Set<State> visitedStates = new HashSet<>();
    Direction currentDirection = Direction.NORTH;
    Point currentPos = startPos;
    visitedPositions.add(currentPos);

    while (true) {
      State currentState = new State(currentPos, currentDirection);
      if (!visitedStates.add(currentState)) {
        return new SimulationResult(visitedPositions, true);
      }

      Point nextPos = new Point(
          currentPos.x() + currentDirection.dx,
          currentPos.y() + currentDirection.dy
      );

      if (!isInsideMap(nextPos, map)) {
        return new SimulationResult(visitedPositions, false);
      }

      if (isObstacle(nextPos, map)) {
        currentDirection = currentDirection.turnRight();
        continue;
      }

      currentPos = nextPos;
      visitedPositions.add(currentPos);

      if (visitedStates.size() > map.length * map[0].length * 4) {
        return new SimulationResult(visitedPositions, false);
      }
    }
  }

  private char[][] createMap(List<String> lines) {
    char[][] map = new char[lines.size()][lines.getFirst().length()];
    for (int i = 0; i < lines.size(); i++) {
      map[i] = lines.get(i).toCharArray();
    }
    return map;
  }

  private Point findStartPosition(char[][] map) {
    for (int y = 0; y < map.length; y++) {
      for (int x = 0; x < map[y].length; x++) {
        if (map[y][x] == '^') {
          return new Point(x, y);
        }
      }
    }
    throw new IllegalStateException("No start position found");
  }

  private char[][] copyMap(char[][] original) {
    char[][] copy = new char[original.length][];
    for (int i = 0; i < original.length; i++) {
      copy[i] = original[i].clone();
    }
    return copy;
  }

  private boolean isInsideMap(Point pos, char[][] map) {
    return pos.y() >= 0 && pos.y() < map.length &&
        pos.x() >= 0 && pos.x() < map[pos.y()].length;
  }

  private boolean isObstacle(Point pos, char[][] map) {
    return map[pos.y()][pos.x()] == '#';
  }

}
