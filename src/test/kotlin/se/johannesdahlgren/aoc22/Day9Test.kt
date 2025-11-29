package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day9Test {
    @Test
    fun part1Example() {
        val day9 = Day9("day9Example")
        assertThat(day9.calcTailUniqueVisits(2)).isEqualTo(13)
    }

    @Test
    fun part1() {
        val day9 = Day9("day9")
        assertThat(day9.calcTailUniqueVisits(2)).isEqualTo(6337)
    }

    @Test
    fun part2Example() {
        val day9 = Day9("day9Example")
        assertThat(day9.calcTailUniqueVisits(10)).isEqualTo(1)
    }

    @Test
    fun part2Example2() {
        val day9 = Day9("day9Example2")
        assertThat(day9.calcTailUniqueVisits(10)).isEqualTo(36)
    }

    @Test
    fun part2() {
        val day9 = Day9("day9")
        assertThat(day9.calcTailUniqueVisits(10)).isEqualTo(2455)
    }
}