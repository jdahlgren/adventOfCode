package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day11Test {
    @Test
    fun part1Example() {
        val day11 = Day11("day11Example")
        assertThat(day11.monkeyBusiness()).isEqualTo(10605L)

    }

    @Test
    fun part1() {
        val day11 = Day11("day11")
        assertThat(day11.monkeyBusiness()).isEqualTo(118674L)
    }
}