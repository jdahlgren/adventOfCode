package se.johannesdahlgren.util;

public record Point3D(int x, int y, int z) {
  public double euclideanDistance(Point3D otherPoint) {
    double xPow = Math.pow(x - otherPoint.x, 2);
    double yPow = Math.pow(y - otherPoint.y, 2);
    double zPow = Math.pow(z - otherPoint.z, 2);
    return Math.sqrt(xPow + yPow + zPow);
  }
}
