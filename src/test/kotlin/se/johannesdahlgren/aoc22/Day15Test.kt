package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day15Test {
    @Test
    fun part1Example() {
        val day15 = Day15("day15Example")
        assertThat(day15.numberOfPosCantContainBeacon(10)).isEqualTo(26)
    }

    @Test
    fun part1() {
        val day15 = Day15("day15")
        assertThat(day15.numberOfPosCantContainBeacon(2000000)).isEqualTo(4879972)
    }
}