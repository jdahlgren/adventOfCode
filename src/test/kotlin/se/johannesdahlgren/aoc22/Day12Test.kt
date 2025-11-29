package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day12Test {
    @Test
    fun part1Example() {
        val day12 = Day12("day12Example")
        assertThat(day12.fewestStepToBestSignal()).isEqualTo(31)
    }

    @Test
    fun part1() {
        val day12 = Day12("day12")
        assertThat(day12.fewestStepToBestSignal()).isEqualTo(408)
    }

    @Test
    fun part2Example() {
        val day12 = Day12("day12Example")
        assertThat(day12.fewestStepToBestSignalStartAny()).isEqualTo(29)
    }

    @Test
    fun part2() {
        val day12 = Day12("day12")
        assertThat(day12.fewestStepToBestSignalStartAny()).isEqualTo(399)
    }
}