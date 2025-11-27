package se.johannesdahlgren.aoc24;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.johannesdahlgren.util.Pair;

public class Day1 {

  private static final Logger log = LoggerFactory.getLogger(Day1.class);

  public int part1() throws IOException {
    List<Pair> pairs = readPairsFromFile("src/main/resources/2024/day1");
    return calculateColumnDistanceSum(pairs);
  }

  public long part2() throws IOException {
    List<Pair> pairs = readPairsFromFile("src/main/resources/2024/day1");
    Map<Integer, Long> occurrences = countOccurrencesInSecondColumn(pairs);
    log.debug("Occurrences of first column elements in the second column:");
    occurrences.forEach((key, value)
        -> log.debug("{} occurs {} time(s)", key, value));
    return calculateSimilarityScore(occurrences);
  }

  List<Pair> readPairsFromFile(String filePath) throws IOException {
    try (var lines = Files.lines(Path.of(filePath))) {
      return lines
          .map(this::getPair)
          .toList();
    }
  }

  private Pair getPair(String line) {
    String[] parts = line.split("\\s+");
    return new Pair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
  }

  int calculateColumnDistanceSum(List<Pair> pairs) {
    List<Integer> leftColumn = pairs.stream().mapToInt(Pair::left).sorted().boxed().toList();
    List<Integer> rightColumn = pairs.stream().mapToInt(Pair::right).sorted().boxed().toList();

    return IntStream.range(0, leftColumn.size())
        .map(i -> Math.abs(leftColumn.get(i) - rightColumn.get(i)))
        .sum();
  }

  Map<Integer, Long> countOccurrencesInSecondColumn(List<Pair> pairs) {
    List<Integer> firstColumn = pairs.stream().map(Pair::left).toList();
    List<Integer> secondColumn = pairs.stream().map(Pair::right).toList();

    return firstColumn.stream()
        .collect(Collectors.groupingBy(
            element -> element,
            Collectors.summingLong(element ->
                secondColumn.stream().filter(e -> e.equals(element)).count()
            )
        ));
  }

  long calculateSimilarityScore(Map<Integer, Long> occurrences) {
    return occurrences.entrySet().stream()
        .mapToLong(entry -> entry.getKey() * entry.getValue())
        .sum();
  }
}
