package se.johannesdahlgren.adventofcode2019;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import se.johannesdahlgren.adventofcode2019.util.Deck;

class Day22Test {

  @Test
  void example1() {
    Day22 day22 = new Day22("day22_example1");
    Deck deck = new Deck(10);
    day22.shuffle(deck);
    assertThat(deck.getCards()).containsExactly(0, 3, 6, 9, 2, 5, 8, 1, 4, 7);
  }

  @Test
  void example2() {
    Day22 day22 = new Day22("day22_example2");
    Deck deck = new Deck(10);
    day22.shuffle(deck);
    assertThat(deck.getCards()).containsExactly(3, 0, 7, 4, 1, 8, 5, 2, 9, 6);
  }

  @Test
  void example3() {
    Day22 day22 = new Day22("day22_example3");
    Deck deck = new Deck(10);
    day22.shuffle(deck);
    assertThat(deck.getCards()).containsExactly(6, 3, 0, 7, 4, 1, 8, 5, 2, 9);
  }

  @Test
  void example4() {
    Day22 day22 = new Day22("day22_example4");
    Deck deck = new Deck(10);
    day22.shuffle(deck);
    assertThat(deck.getCards()).containsExactly(9, 2, 5, 8, 1, 4, 7, 0, 3, 6);
  }

  @Test
  void shuffle() {
    Day22 day22 = new Day22("day22");
    Deck deck = new Deck(10007);
    day22.shuffle(deck);
    int index = deck.getCards().indexOf(2019);
    assertThat(index).isEqualTo(6129);
  }
}