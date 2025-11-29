package se.johannesdahlgren.aoc22

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day10Test {
    @Test
    fun part1Example() {
        val day10 = Day10("day10Example")
        assertThat(day10.getSignalStrength()).isEqualTo(13140)
    }

    @Test
    fun part1() {
        val day10 = Day10("day10")
        assertThat(day10.getSignalStrength()).isEqualTo(17380)
    }

    @Test
    fun part2Example() {
        val day10 = Day10("day10Example")
        val expectedResult = """
            ##..##..##..##..##..##..##..##..##..##..
            ###...###...###...###...###...###...###.
            ####....####....####....####....####....
            #####.....#####.....#####.....#####.....
            ######......######......######......####
            #######.......#######.......#######.....
        """.trimIndent()
        assertThat(day10.drawCRTScreen()).isEqualTo(expectedResult)
    }

    @Test
    fun part2() {
        val day10 = Day10("day10")
        val expectedResult = """
            ####..##...##..#..#.####.###..####..##..
            #....#..#.#..#.#..#....#.#..#.#....#..#.
            ###..#....#....#..#...#..#..#.###..#....
            #....#.##.#....#..#..#...###..#....#....
            #....#..#.#..#.#..#.#....#.#..#....#..#.
            #.....###..##...##..####.#..#.####..##..
        """.trimIndent()
        assertThat(day10.drawCRTScreen()).isEqualTo(expectedResult)
    }
}