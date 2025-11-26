package se.johannesdahlgren.aoc23.util;

import java.nio.file.Path;
import java.util.List;
import se.johannesdahlgren.util.FileUtil;

public class FileReader {

  public static List<String> readFileAsLines(String fileName) {
    Path path = getPath(fileName);
    return FileUtil.toLines(path);
  }

  public static List<List<Character>> readFileAsCharMatrix(String fileName) {
    Path path = getPath(fileName);
    return FileUtil.toChar2DList(path);
  }

  public static String readFileToString(String fileName) {
    Path path = getPath(fileName);
    return FileUtil.toString(path);
  }

  private static Path getPath(String fileName) {
    return FileUtil.getPath("2023", fileName);
  }
}
