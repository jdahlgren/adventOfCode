package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5Test {
    @Test
    fun part1Example() {
        val day5 = Day5("day5Example")
        assertThat(day5.getCratesOnTop()).isEqualTo("CMZ")
    }

    @Test
    fun part1() {
        val day5 = Day5("day5")
        assertThat(day5.getCratesOnTop()).isEqualTo("FZCMJCRHZ")
    }

    @Test
    fun part2Example() {
        val day5 = Day5("day5Example")
        assertThat(day5.getCratesOnTopMultiCrate()).isEqualTo("MCD")
    }

    @Test
    fun part2() {
        val day5 = Day5("day5")
        assertThat(day5.getCratesOnTopMultiCrate()).isEqualTo("JSDHQMZGF")
    }

}