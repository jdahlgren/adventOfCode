package se.johannesdahlgren.aoc22.util

class FileReader {
    companion object {

        fun readFileAsStringSplitEmptyLine(fileName: String): List<String> {
            val filePath = "/2022/$fileName.txt"
            return FileReader::class.java.getResource(filePath)!!.readText()
                .split("\n\n")
        }

        fun readFileLinesAsString(fileName: String): List<String> {
            val filePath = "/2022/$fileName.txt"
            return FileReader::class.java.getResource(filePath)!!.readText()
                .lines()
        }

        fun readFileAsString(fileName: String): String {
            val filePath = "/2022/$fileName.txt"
            return FileReader::class.java.getResource(filePath)!!.readText()
                .lines()
                .first()
        }
    }
}