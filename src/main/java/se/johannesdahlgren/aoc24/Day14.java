package se.johannesdahlgren.aoc24;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day14 {
  record Robot(Pair position, Pair velocity) {
    Robot move(int width, int height) {
      int newX = Math.floorMod(position.x + velocity.x, width);
      int newY = Math.floorMod(position.y + velocity.y, height);
      return new Robot(new Pair(newX, newY), velocity);
    }

    String getQuadrant(int width, int height) {
      int midX = width / 2;
      int midY = height / 2;

      if (position.x == midX || position.y == midY) {
        return "middle";
      }

      if (position.x < midX) {
        return position.y < midY ? "top-left" : "bottom-left";
      } else {
        return position.y < midY ? "top-right" : "bottom-right";
      }
    }
  }
  record Pair(int x, int y) {}

  private static final int ROOM_WIDTH = 101;
  private static final int ROOM_HEIGHT = 103;
  private List<Robot> robots;

  public Day14() throws Exception {
    robots = readRobots("src/main/resources/2024/day14");
  }

  public long safetyFactor(int seconds) {
    for (int second = 1; second <= seconds; second++) {
      robots = robots.stream()
          .map(r -> r.move(ROOM_WIDTH, ROOM_HEIGHT))
          .toList();

      if (second == 100 && seconds == 100) {
        return getProduct();
      }

      if (hasLargeCluster(robots)) {
        printRoom(robots, ROOM_WIDTH, ROOM_HEIGHT);
        return second;
      }
    }
    return -1L;
  }

  public long getProduct() {
    long topLeft = robots.stream()
        .filter(r -> r.getQuadrant(ROOM_WIDTH, ROOM_HEIGHT).equals("top-left"))
        .count();

    long topRight = robots.stream()
        .filter(r -> r.getQuadrant(ROOM_WIDTH, ROOM_HEIGHT).equals("top-right"))
        .count();

    long bottomLeft = robots.stream()
        .filter(r -> r.getQuadrant(ROOM_WIDTH, ROOM_HEIGHT).equals("bottom-left"))
        .count();

    long bottomRight = robots.stream()
        .filter(r -> r.getQuadrant(ROOM_WIDTH, ROOM_HEIGHT).equals("bottom-right"))
        .count();
    return topLeft * topRight * bottomLeft * bottomRight;
  }

  private static boolean hasLargeCluster(List<Robot> robots) {
    if (robots.isEmpty()) return false;

    // Find the main cluster
    Set<Pair> visited = new HashSet<>();
    List<Set<Pair>> clusters = new ArrayList<>();

    for (Robot robot : robots) {
      if (visited.contains(robot.position)) continue;

      Set<Pair> cluster = new HashSet<>();
      Queue<Pair> queue = new LinkedList<>();
      queue.add(robot.position);

      while (!queue.isEmpty()) {
        Pair pos = queue.poll();
        if (!visited.add(pos)) continue;
        cluster.add(pos);

        // Check all adjacent positions (including diagonal)
        for (Robot other : robots) {
          if (visited.contains(other.position)) continue;
          if (isAdjacent(pos, other.position)) {
            queue.add(other.position);
          }
        }
      }

      clusters.add(cluster);
    }

    // Find the largest cluster
    Optional<Set<Pair>> largestCluster = clusters.stream()
        .max(Comparator.comparingInt(Set::size));

    // Check if the largest cluster contains at least 90% of all robots
    return largestCluster.map(cluster ->
        (double) cluster.size() / robots.size() >= 0.2
    ).orElse(false);
  }

  private static boolean isAdjacent(Pair p1, Pair p2) {
    int dx = Math.abs(p1.x - p2.x);
    int dy = Math.abs(p1.y - p2.y);
    return dx <= 1 && dy <= 1;
  }

  private static void printRoom(List<Robot> robots, int width, int height) {
    char[][] grid = new char[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        grid[y][x] = '.';
      }
    }

    for (Robot robot : robots) {
      grid[robot.position.y][robot.position.x] = '#';
    }

    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        System.out.print(grid[y][x]);
      }
      System.out.println();
    }
  }

  private static List<Robot> readRobots(String filename) throws Exception {
    List<Robot> robots = new ArrayList<>();
    Path path = Paths.get(filename);

    List<String> lines = Files.readAllLines(path);
    for (String line : lines) {
      if (line.isEmpty()) continue;

      String[] parts = line.split(" ");
      Pair position = parsePair(parts[0].substring(2));
      Pair velocity = parsePair(parts[1].substring(2));

      robots.add(new Robot(position, velocity));
    }

    return robots;
  }

  private static Pair parsePair(String input) {
    String[] coordinates = input.split(",");
    return new Pair(
        Integer.parseInt(coordinates[0]),
        Integer.parseInt(coordinates[1])
    );
  }
}
