package se.johannesdahlgren.adventofcode2021;

public final class BingoNumber {

  private final int number;
  private boolean isMarked;

  public BingoNumber(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setMarked(boolean isMarked) {
    this.isMarked = isMarked;
  }

  public boolean isMarked() {
    return isMarked;
  }
}
