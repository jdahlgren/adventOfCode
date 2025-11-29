package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day7Test {
    @Test
    fun part1Example() {
        val day7 = Day7("day7Example")
        assertThat(day7.calcTotalSize(100000)).isEqualTo(95437)
    }

    @Test
    fun part1() {
        val day7 = Day7("day7")
        assertThat(day7.calcTotalSize(100000)).isEqualTo(1206825)
    }

    @Test
    fun part2Example() {
        val day7 = Day7("day7Example")
        assertThat(day7.findSmallestFolder(30000000)).isEqualTo(24933642)
    }

    @Test
    fun part2() {
        val day7 = Day7("day7")
        assertThat(day7.findSmallestFolder(30000000)).isEqualTo(9608311)
    }
}