package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class Day14Test {

    @Test
    fun part1Example() {
        val day14 = Day14("day14Example")
        assertThat(day14.calcUnitOfSandAtRest(0)).isEqualTo(24)
    }

    @Test
    fun part1() {
        val day14 = Day14("day14")
        assertThat(day14.calcUnitOfSandAtRest(0)).isEqualTo(737)
    }

    @Test
    fun part2Example() {
        val day14 = Day14("day14Example")
        assertThat(day14.calcUnitOfSandAtRest(2)).isEqualTo(93)
    }

    @Disabled("Slow, around 2 minutes")
    @Test
    fun part2() {
        val day14 = Day14("day14")
        assertThat(day14.calcUnitOfSandAtRest(2)).isEqualTo(28145)
    }
}