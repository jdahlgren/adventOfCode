package se.johannesdahlgren.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileUtil {

  private FileUtil() {
  }

  public static Path getPath(String year, String fileName) {
    return Paths.get("src/main/resources/" + year + "/" + fileName);
  }

  public static String toString(Path path) {
    try {
      return Files.readString(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<String> toLines(Path path) {
    try {
      return Files.readAllLines(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static List<Integer> toIntLines(Path path) {
    return toLines(path).stream()
        .map(Integer::valueOf)
        .toList();
  }

  public static List<Integer> toIntLinesFromCsv(Path path) {
    return toLines(path).stream()
        .map(line -> line.split(","))
        .flatMap(Stream::of)
        .map(Integer::valueOf)
        .toList();
  }

  public static List<Integer> toIntListFromCsv(Path path) {
    return Stream.of(toString(path)
            .split(","))
        .map(Integer::valueOf)
        .toList();
  }

  public static List<List<Character>> toChar2DList(Path path) {
    return toLines(path).stream()
        .map(line -> line.chars()
            .mapToObj(c -> (char) c)
            .toList())
        .toList();
  }

  public static List<List<Integer>> toInt2DList(Path path) {
    return toLines(path).stream()
        .map(line -> line.chars()
            .mapToObj(Character::getNumericValue)
            .toList())
        .toList();
  }

  public static int[][] toInt2DArray(Path path) {
    List<String> lines = toLines(path);

    int width = lines.getFirst().length();

    return IntStream.range(0, width)
        .mapToObj(col ->
            lines.stream()
                .mapToInt(line -> Character.getNumericValue(line.charAt(col)))
                .toArray()
        )
        .toArray(int[][]::new);
  }

  public static char[][] toChar2DArray(List<String> lines) {
    return lines.stream()
        .map(line -> line.chars()
            .mapToObj(c -> (char) c)
            .collect(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append
            )
            .toString()
            .toCharArray()
        )
        .toArray(char[][]::new);
  }
}
