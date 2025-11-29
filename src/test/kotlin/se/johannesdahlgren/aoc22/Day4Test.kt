package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun part1Example() {
        val day4 = Day4("day4Example")
        assertThat(day4.numberOfAssignmentPairsFullyContained()).isEqualTo(2)
    }

    @Test
    fun part1() {
        val day4 = Day4("day4")
        assertThat(day4.numberOfAssignmentPairsFullyContained()).isEqualTo(515)
    }

    @Test
    fun part2Example() {
        val day4 = Day4("day4Example")
        assertThat(day4.numberOfAssignmentPairsOverlap()).isEqualTo(4)
    }

    @Test
    fun part2() {
        val day4 = Day4("day4")
        assertThat(day4.numberOfAssignmentPairsOverlap()).isEqualTo(883)
    }
}