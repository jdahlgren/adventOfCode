package se.johannesdahlgren.aoc24;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import se.johannesdahlgren.util.Point;

public class Day14 {
  record Robot(Point position, Point velocity) {
    Robot move() {
      int newX = Math.floorMod(position.x() + velocity.x(), Day14.ROOM_WIDTH);
      int newY = Math.floorMod(position.y() + velocity.y(), Day14.ROOM_HEIGHT);
      return new Robot(new Point(newX, newY), velocity);
    }

    String getQuadrant() {
      int midX = Day14.ROOM_WIDTH / 2;
      int midY = Day14.ROOM_HEIGHT / 2;

      if (position.x() == midX || position.y() == midY) {
        return "middle";
      }

      if (position.x() < midX) {
        return position.y() < midY ? "top-left" : "bottom-left";
      } else {
        return position.y() < midY ? "top-right" : "bottom-right";
      }
    }
  }

  private static final int ROOM_WIDTH = 101;
  private static final int ROOM_HEIGHT = 103;
  private List<Robot> robots;

  public Day14() throws Exception {
    robots = readRobots();
  }

  public long safetyFactor(int seconds) {
    for (int second = 1; second <= seconds; second++) {
      robots = robots.stream()
          .map(Robot::move)
          .toList();

      if (second == 100 && seconds == 100) {
        return getProduct();
      }

      if (hasLargeCluster(robots)) {
        printRoom(robots);
        return second;
      }
    }
    return -1L;
  }

  public long getProduct() {
    long topLeft = robots.stream()
        .filter(r -> r.getQuadrant().equals("top-left"))
        .count();

    long topRight = robots.stream()
        .filter(r -> r.getQuadrant().equals("top-right"))
        .count();

    long bottomLeft = robots.stream()
        .filter(r -> r.getQuadrant().equals("bottom-left"))
        .count();

    long bottomRight = robots.stream()
        .filter(r -> r.getQuadrant().equals("bottom-right"))
        .count();
    return topLeft * topRight * bottomLeft * bottomRight;
  }

  private static boolean hasLargeCluster(List<Robot> robots) {
    if (robots.isEmpty()) return false;

    // Find the main cluster
    Set<Point> visited = new HashSet<>();
    List<Set<Point>> clusters = new ArrayList<>();

    for (Robot robot : robots) {
      if (visited.contains(robot.position)) continue;

      Set<Point> cluster = new HashSet<>();
      Queue<Point> queue = new LinkedList<>();
      queue.add(robot.position);

      while (!queue.isEmpty()) {
        Point pos = queue.poll();
        if (!visited.add(pos)) continue;
        cluster.add(pos);

        // Check all adjacent positions (including diagonal)
        for (Robot other : robots) {
          if (visited.contains(other.position)) continue;
          if (pos.isAdjacent(other.position)) {
            queue.add(other.position);
          }
        }
      }

      clusters.add(cluster);
    }

    // Find the largest cluster
    Optional<Set<Point>> largestCluster = clusters.stream()
        .max(Comparator.comparingInt(Set::size));

    // Check if the largest cluster contains at least 90% of all robots
    return largestCluster.map(cluster ->
        (double) cluster.size() / robots.size() >= 0.2
    ).orElse(false);
  }

  private static void printRoom(List<Robot> robots) {
    char[][] grid = new char[Day14.ROOM_HEIGHT][Day14.ROOM_WIDTH];
    for (int y = 0; y < Day14.ROOM_HEIGHT; y++) {
      for (int x = 0; x < Day14.ROOM_WIDTH; x++) {
        grid[y][x] = '.';
      }
    }

    for (Robot robot : robots) {
      grid[robot.position.y()][robot.position.x()] = '#';
    }

    for (int y = 0; y < Day14.ROOM_HEIGHT; y++) {
      for (int x = 0; x < Day14.ROOM_WIDTH; x++) {
        System.out.print(grid[y][x]);
      }
      System.out.println();
    }
  }

  private static List<Robot> readRobots() throws Exception {
    List<Robot> robots = new ArrayList<>();
    Path path = Paths.get("src/main/resources/2024/day14");

    List<String> lines = Files.readAllLines(path);
    for (String line : lines) {
      if (line.isEmpty()) continue;

      String[] parts = line.split(" ");
      Point position = parsePair(parts[0].substring(2));
      Point velocity = parsePair(parts[1].substring(2));

      robots.add(new Robot(position, velocity));
    }

    return robots;
  }

  private static Point parsePair(String input) {
    String[] coordinates = input.split(",");
    return new Point(
        Integer.parseInt(coordinates[0]),
        Integer.parseInt(coordinates[1])
    );
  }
}
