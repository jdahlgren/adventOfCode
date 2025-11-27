package se.johannesdahlgren.util;

public record Line(Point start, Point end) {

  public boolean isHorizontal() {
    return start.x() == end.x();
  }

  public boolean isVertical() {
    return start.y() == end.y();
  }

  public boolean isDiagonal() {
    return !isHorizontal() && !isVertical();
  }

  public int getStartX() {
    return start.x();
  }

  public int getStartY() {
    return start.y();
  }

  public int getEndX() {
    return end.x();
  }

  public int getEndY() {
    return end.y();
  }

  public int getMaxX() {
    return Math.max(start.x(), end.x());
  }

  public int getMaxY() {
    return Math.max(start.y(), end.y());
  }
}
