package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day8Test {
    @Test
    fun part1Example() {
        val day8 = Day8("day8Example")
        assertThat(day8.visibleTrees()).isEqualTo(21)
    }

    @Test
    fun part1() {
        val day8 = Day8("day8")
        assertThat(day8.visibleTrees()).isEqualTo(1814)
    }

    @Test
    fun part2Example() {
        val day8 = Day8("day8Example")
        assertThat(day8.scenicScore()).isEqualTo(8)
    }

    @Test
    fun part2() {
        val day8 = Day8("day8")
        assertThat(day8.scenicScore()).isEqualTo(330786)
    }
}