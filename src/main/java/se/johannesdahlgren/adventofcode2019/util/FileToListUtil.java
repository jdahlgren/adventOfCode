package se.johannesdahlgren.adventofcode2019.util;

import java.nio.file.Path;
import java.util.List;
import se.johannesdahlgren.util.FileUtil;

public class FileToListUtil {

  public static List<Integer> getIntCode(String filePath) {
    return getListFromFile(filePath, FileUtil::toIntListFromCsv);
  }

  public static List<Integer> getModuleMassFromFile(String filePath) {
    return getListFromFile(filePath, FileUtil::toIntLines);
  }

  public static List<String> getLinePathFromFile(String filePath) {
    return getListFromFile(filePath, FileUtil::toLines);
  }

  private static <T> List<T> getListFromFile(String filePath, CheckedFunction<Path, List<T>> function) {
    Path path = FileUtil.getPath("2019", filePath);
    return function.apply(path);
  }
}