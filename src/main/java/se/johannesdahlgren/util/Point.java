package se.johannesdahlgren.util;

public record Point(int x, int y) {

  public Point nextPosition(Direction direction) {
    return switch (direction) {
      case UP -> new Point(x, y - 1);
      case DOWN -> new Point(x, y + 1);
      case RIGHT -> new Point(x + 1, y);
      case LEFT -> new Point(x - 1, y);
      case UP_LEFT -> new Point(x - 1, y + 1);
      case UP_RIGHT -> new Point(x + 1, y + 1);
      case DOWN_LEFT -> new Point(x - 1, y - 1);
      case DOWN_RIGHT -> new Point(x + 1, y - 1);
    };
  }

  public boolean isInBounds(int width, int height) {
    return x >= 0 && x < width && y >= 0 && y < height;
  }

  public boolean isAdjacent(Point otherPoint) {
    int dx = Math.abs(x - otherPoint.x());
    int dy = Math.abs(y - otherPoint.y());
    return dx <= 1 && dy <= 1;
  }
}
