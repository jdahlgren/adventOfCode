package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day18Test {

    @Test
    fun part1Example() {
        val day18 = Day18("day18Example")
        assertThat(day18.getSurfaceArea()).isEqualTo(10)
    }

    @Test
    fun part1Example2() {
        val day18 = Day18("day18Example2")
        assertThat(day18.getSurfaceArea()).isEqualTo(64)
    }

    @Test
    fun part1() {
        val day18 = Day18("day18")
        assertThat(day18.getSurfaceArea()).isEqualTo(4364)
    }
}