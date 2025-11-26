package se.johannesdahlgren.adventofcode2021;

import java.nio.file.Path;
import java.util.List;

public class FileUtil {

  public static List<Integer> readFileToIntList(String inputFile) {
    Path path = getPath(inputFile);
    return se.johannesdahlgren.util.FileUtil.toIntLines(path);
  }

  public static List<Integer> readCsvFileToIntList(String inputFile) {
    Path path = getPath(inputFile);
    return se.johannesdahlgren.util.FileUtil.toIntLinesFromCsv(path);
  }

  public static List<String> readFileToStringList(String inputFile) {
    Path path = getPath(inputFile);
    return se.johannesdahlgren.util.FileUtil.toLines(path);
  }

  public static List<List<Integer>> readFileToInteger2DList(String inputFile) {
    Path path = getPath(inputFile);
    return se.johannesdahlgren.util.FileUtil.toInt2DList(path);
  }

  public static int[][] readFileToInteger2DArray(String inputFile) {
    Path path = getPath(inputFile);
    return se.johannesdahlgren.util.FileUtil.toInt2DArray(path);
  }

  public static char[][] linesToString2DArray(List<String> lines) {
    return se.johannesdahlgren.util.FileUtil.toChar2DArray(lines);
  }

  private static Path getPath(String inputFile) {
    return se.johannesdahlgren.util.FileUtil.getPath("2021", inputFile);
  }
}
