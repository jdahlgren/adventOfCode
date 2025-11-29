package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun part1Example() {
        val day3 = Day3("day3Example")
        assertThat(day3.prioritiesSum()).isEqualTo(157)
    }

    @Test
    fun part1() {
        val day3 = Day3("day3")
        assertThat(day3.prioritiesSum()).isEqualTo(8176)
    }

    @Test
    fun part2Example() {
        val day3 = Day3("day3Example")
        assertThat(day3.prioritiesSumElfGroup()).isEqualTo(70)
    }

    @Test
    fun part2() {
        val day3 = Day3("day3")
        assertThat(day3.prioritiesSumElfGroup()).isEqualTo(2689)
    }
}