package se.johannesdahlgren.adventofcode2021;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import se.johannesdahlgren.util.Line;

public final class HydroThermalVentsMap {

  private final List<Line> hydroThermalVentsLines;
  private final int[][] hydrothermalVentsMap;

  public HydroThermalVentsMap(List<Line> hydroThermalVentsLines) {
    this.hydroThermalVentsLines = hydroThermalVentsLines;
    int maxX = getMaxX(hydroThermalVentsLines);
    int maxY = getMaxY(hydroThermalVentsLines);
    hydrothermalVentsMap = new int[maxX + 1][maxY + 1];
  }

  public void drawHorizontalAndVerticalLines() {
    for (Line hydroThermalVentsLine : hydroThermalVentsLines) {
      if (hydroThermalVentsLine.isHorizontal()) {
        drawHorizontalLine(hydroThermalVentsLine);
      }
      if (hydroThermalVentsLine.isVertical()) {
        drawVerticalLine(hydroThermalVentsLine);
      }
    }
  }

  public void drawDiagonalLines() {
    for (Line hydroThermalVentsLine : hydroThermalVentsLines) {
      if (hydroThermalVentsLine.isDiagonal()) {
        drawDiagonalLine(hydroThermalVentsLine);
      }
    }
  }

  public long calculateOverlappingLines(int atLeastNumberOfOverlaps) {
    return Arrays.stream(hydrothermalVentsMap)
        .flatMapToInt(Arrays::stream)
        .filter(point -> point >= atLeastNumberOfOverlaps)
        .count();
  }

  public void printMap() {
    for (int[] rows : hydrothermalVentsMap) {
      for (int point : rows) {
        System.out.print(point);
      }
      System.out.println();
    }
  }

  private void drawVerticalLine(Line hydroThermalVentsLine) {
    if (hydroThermalVentsLine.getStartX() < hydroThermalVentsLine.getEndX()) {
      IntStream.rangeClosed(hydroThermalVentsLine.getStartX(), hydroThermalVentsLine.getEndX())
          .forEach(x -> hydrothermalVentsMap[hydroThermalVentsLine.getStartY()][x] += 1);
    } else {
      IntStream.rangeClosed(hydroThermalVentsLine.getEndX(), hydroThermalVentsLine.getStartX())
          .forEach(x -> hydrothermalVentsMap[hydroThermalVentsLine.getStartY()][x] += 1);
    }
  }

  private void drawHorizontalLine(Line hydroThermalVentsLine) {
    if (hydroThermalVentsLine.getStartY() < hydroThermalVentsLine.getEndY()) {
      IntStream.rangeClosed(hydroThermalVentsLine.getStartY(), hydroThermalVentsLine.getEndY())
          .forEach(y -> hydrothermalVentsMap[y][hydroThermalVentsLine.getStartX()] += 1);
    } else {
      IntStream.rangeClosed(hydroThermalVentsLine.getEndY(), hydroThermalVentsLine.getStartY())
          .forEach(y -> hydrothermalVentsMap[y][hydroThermalVentsLine.getStartX()] += 1);
    }
  }

  private void drawDiagonalLine(Line hydroThermalVentsLine) {
    if (hydroThermalVentsLine.getStartX() < hydroThermalVentsLine.getEndX()) {
      drawDiagonalLeftToRight(hydroThermalVentsLine);
    } else {
      drawDiagonalRightToLeft(hydroThermalVentsLine);
    }
  }

  private void drawDiagonalLeftToRight(Line hydroThermalVentsLine) {
    int steps = hydroThermalVentsLine.getEndX() - hydroThermalVentsLine.getStartX();
    if (hydroThermalVentsLine.getStartY() < hydroThermalVentsLine.getEndY()) {
      for (int i = 0; i <= steps; i++) {
        hydrothermalVentsMap[hydroThermalVentsLine.getStartY() + i][hydroThermalVentsLine.getStartX() + i] += 1;
      }
    } else {
      for (int i = 0; i <= steps; i++) {
        hydrothermalVentsMap[hydroThermalVentsLine.getStartY() - i][hydroThermalVentsLine.getStartX() + i] += 1;
      }
    }
  }

  private void drawDiagonalRightToLeft(Line hydroThermalVentsLine) {
    int steps = hydroThermalVentsLine.getStartX() - hydroThermalVentsLine.getEndX();
    if (hydroThermalVentsLine.getStartY() < hydroThermalVentsLine.getEndY()) {
      for (int i = 0; i <= steps; i++) {
        hydrothermalVentsMap[hydroThermalVentsLine.getStartY() + i][hydroThermalVentsLine.getStartX() - i] += 1;
      }
    } else {
      for (int i = 0; i <= steps; i++) {
        hydrothermalVentsMap[hydroThermalVentsLine.getStartY() - i][hydroThermalVentsLine.getStartX() - i] += 1;
      }
    }
  }

  private int getMaxX(List<Line> hydroThermalVentsLines) {
    int maxX = 0;
    for (Line hydroThermalVentsLine : hydroThermalVentsLines) {
      if (hydroThermalVentsLine.getMaxX() > maxX) {
        maxX = hydroThermalVentsLine.getMaxX();
      }
    }
    return maxX;
  }

  private int getMaxY(List<Line> hydroThermalVentsLines) {
    int maxY = 0;
    for (Line hydroThermalVentsLine : hydroThermalVentsLines) {
      if (hydroThermalVentsLine.getMaxY() > maxY) {
        maxY = hydroThermalVentsLine.getMaxY();
      }
    }
    return maxY;
  }
}
