package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun part1Example() {
        val day2 = Day2("day2Example")
        assertThat(day2.getTotalScore()).isEqualTo(15)
    }

    @Test
    fun part1() {
        val day2 = Day2("day2")
        assertThat(day2.getTotalScore()).isEqualTo(12855)
    }

    @Test
    fun part2Example() {
        val day2 = Day2("day2Example")
        assertThat(day2.getTotalScoreFollowGuide()).isEqualTo(12)
    }

    @Test
    fun part2() {
        val day2 = Day2("day2")
        assertThat(day2.getTotalScoreFollowGuide()).isEqualTo(13726)
    }
}