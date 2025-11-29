package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day6Test {
    @Test
    fun part1Example1() {
        val day6 = Day6("day6Example1")
        assertThat(day6.getStartOfPacketMarker()).isEqualTo(7)
    }

    @Test
    fun part1Example2() {
        val day6 = Day6("day6Example2")
        assertThat(day6.getStartOfPacketMarker()).isEqualTo(5)
    }

    @Test
    fun part1Example3() {
        val day6 = Day6("day6Example3")
        assertThat(day6.getStartOfPacketMarker()).isEqualTo(6)
    }

    @Test
    fun part1Example4() {
        val day6 = Day6("day6Example4")
        assertThat(day6.getStartOfPacketMarker()).isEqualTo(10)
    }

    @Test
    fun part1Example5() {
        val day6 = Day6("day6Example5")
        assertThat(day6.getStartOfPacketMarker()).isEqualTo(11)
    }

    @Test
    fun part1() {
        val day6 = Day6("day6")
        assertThat(day6.getStartOfPacketMarker()).isEqualTo(1109)
    }

    @Test
    fun part2Example1() {
        val day6 = Day6("day6Example1")
        assertThat(day6.getStartOfMessageMarker()).isEqualTo(19)
    }

    @Test
    fun part2Example2() {
        val day6 = Day6("day6Example2")
        assertThat(day6.getStartOfMessageMarker()).isEqualTo(23)
    }

    @Test
    fun part2Example3() {
        val day6 = Day6("day6Example3")
        assertThat(day6.getStartOfMessageMarker()).isEqualTo(23)
    }

    @Test
    fun part2Example4() {
        val day6 = Day6("day6Example4")
        assertThat(day6.getStartOfMessageMarker()).isEqualTo(29)
    }

    @Test
    fun part2Example5() {
        val day6 = Day6("day6Example5")
        assertThat(day6.getStartOfMessageMarker()).isEqualTo(26)
    }

    @Test
    fun part2() {
        val day6 = Day6("day6")
        assertThat(day6.getStartOfMessageMarker()).isEqualTo(3965)
    }
}