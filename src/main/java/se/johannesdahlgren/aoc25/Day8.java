package se.johannesdahlgren.aoc25;

import se.johannesdahlgren.util.FileUtil;
import se.johannesdahlgren.util.Point3D;

import java.util.*;
import java.util.stream.Collectors;

import static se.johannesdahlgren.util.FileUtil.getPath;

public class Day8 {

  private final List<Set<Point3D>> circuits;
  private final List<Point3D> unconnectedJunctions;

  public Day8(String fileName) {
    List<String> lines = FileUtil.toLines(getPath("2025", "day8" + fileName));
    unconnectedJunctions = lines.stream()
        .map(line -> line.split(","))
        .map(split -> new Point3D(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])))
        .collect(Collectors.toList());
    circuits = new ArrayList<>();
  }

  public int threeLargestCircuits(int numberOfConnections) {

    List<BoxDistance> shortest = distances().subList(0, numberOfConnections);
    for (BoxDistance boxDistance : shortest) {
      addToCircuit(boxDistance.a(), boxDistance.b());
    }
    mergeConnections();

    return circuits.stream()
        .map(Set::size)
        .sorted()
        .toList()
        .reversed()
        .subList(0, 3)
        .stream()
        .reduce(1, (integer, integer2) -> integer * integer2);
  }

  public int connectAll() {
    List<BoxDistance> shortest = distances();
    for (BoxDistance boxDistance : shortest) {
      addToCircuit(boxDistance.a(), boxDistance.b());
      mergeConnections();
      if (circuits.stream().anyMatch(set -> set.size() == unconnectedJunctions.size())) {
        return boxDistance.a().x() * boxDistance.b().x();
      }
    }
    return -1;
  }

  private void mergeConnections() {
    for (Set<Point3D> circuit : circuits) {
      for (Set<Point3D> circuit2 : circuits) {
        if (!circuit.containsAll(circuit2) && circuit.stream().anyMatch(circuit2::contains)) {
          circuit.addAll(circuit2);
          circuit2.clear();
        }
      }
    }
  }

  private void addToCircuit(Point3D a, Point3D b) {

    List<Point3D> list = circuits.stream().flatMap(Collection::stream).toList();
    if (!list.contains(a) && !list.contains(b)) {
      HashSet<Point3D> connections = new HashSet<>();
      connections.add(a);
      connections.add(b);
      circuits.add(new HashSet<>(connections));
    } else if (list.contains(a) && list.contains(b)) {
      circuits.stream()
          .filter(c -> c.contains(b))
          .findFirst()
          .ifPresent(c -> c.add(a));
      circuits.stream()
          .filter(c -> c.contains(a))
          .findFirst()
          .ifPresent(c -> c.add(b));
    } else if (list.contains(b)) {
      circuits.stream()
          .filter(c -> c.contains(b))
          .findFirst()
          .ifPresent(c -> c.add(a));
    } else if (list.contains(a)) {
      circuits.stream()
          .filter(c -> c.contains(a))
          .findFirst()
          .ifPresent(c -> c.add(b));
    }
  }


  private List<BoxDistance> distances() {

    List<BoxDistance> distances = new ArrayList<>();
    for (Point3D junctionBox : unconnectedJunctions) {
      for (Point3D nextJunctionBox : unconnectedJunctions) {
        if (!junctionBox.equals(nextJunctionBox)) {
          double distance = junctionBox.euclideanDistance(nextJunctionBox);
          BoxDistance boxDistance = new BoxDistance(junctionBox, nextJunctionBox, distance);
          distances.add(boxDistance);
        }
      }
    }
    return distances.stream()
        .sorted()
        .distinct()
        .toList();
  }


  private record BoxDistance(Point3D a, Point3D b, double distance) implements Comparable<BoxDistance> {
    @Override
    public int compareTo(BoxDistance other) {
      return Double.compare(distance, other.distance);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) {
        return true;
      }
      if (other == null) {
        return false;
      }
      if (!(other instanceof BoxDistance o)) {
        return false;
      }
      return (o.a.equals(this.a) && o.b.equals(this.b)) || (o.a.equals(this.b) && o.b.equals(this.a));
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }
  }
}
