package se.johannesdahlgren.adventofcode2021;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import se.johannesdahlgren.util.Point;

public class Day13 {

  private final List<String> instructions;
  private Set<Point> randomDots;

  public Day13(String s) {
    List<String> transparentPaper = FileUtil.readFileToStringList(s);
    instructions = transparentPaper.stream().filter(line -> line.contains("fold along")).toList();
    randomDots = transparentPaper.stream().filter(line -> !line.contains("fold along")).filter(line -> !line.isBlank()).map(this::toPoint)
        .collect(Collectors.toSet());
  }

  public long foldOnce() {
    String firstInstruction = instructions.getFirst();
    doAFold(firstInstruction);
    return randomDots.size();
  }

  public String foldAll() {
    for (String instruction : instructions) {
      doAFold(instruction);
    }
    return printCode();
  }

  private void doAFold(String firstInstruction) {
    Matcher matcher = Pattern.compile("([yx])=(\\d+)").matcher(firstInstruction);
    if (!matcher.find()) {
      return;
    }

    boolean isHorizontal = "y".equals(matcher.group(1));
    int foldSize = Integer.parseInt(matcher.group(2));
    fold(isHorizontal, foldSize);
  }

  private void fold(boolean isHorizontal, int foldSize) {
    Set<Point> dotsAfterFold = new HashSet<>();

    for (Point randomDot : randomDots) {
      if (isHorizontal && randomDot.y() > foldSize) {
        int newY = foldSize - (randomDot.y() - foldSize);
        dotsAfterFold.add(new Point(randomDot.x(), newY));
      } else if (!isHorizontal && randomDot.x() > foldSize) {
        int newX = foldSize - (randomDot.x() - foldSize);
        dotsAfterFold.add(new Point(newX, randomDot.y()));
      } else {
        dotsAfterFold.add(randomDot);
      }

    }
    randomDots = dotsAfterFold;
  }

  private String printCode() {
    int xMaxAtEnd = randomDots.stream().map(Point::x).max(Comparator.naturalOrder()).orElse(0);
    int yMaxAtEnd = randomDots.stream().map(Point::y).max(Comparator.naturalOrder()).orElse(0);
    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < yMaxAtEnd + 1; j++) {
      for (int i = 0; i < xMaxAtEnd + 1; i++) {
        if (randomDots.contains(new Point(i, j))) {
          sb.append("#");
        } else {
          sb.append(" ");
        }
      }
      sb.append("\n");
    }
    System.out.println(sb);
    return sb.toString();
  }

  private Point toPoint(String line) {
    String[] split = line.split(",");
    return new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
  }

}
