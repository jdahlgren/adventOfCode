package se.johannesdahlgren.aoc23;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import se.johannesdahlgren.aoc23.util.FileReader;
import se.johannesdahlgren.util.StringPair;

public class Day8 {

  private final String fileName;

  public Day8(String fileName) {

    this.fileName = fileName;
  }

  public int numberOfStepsToEnd() {
    List<String> input = FileReader.readFileAsLines(fileName);
    char[] rlInstructions = input.getFirst().toCharArray();
    Map<String, StringPair> rlMaps = input.stream()
        .skip(2)
        .collect(Collectors.toMap(line -> line.substring(0, 3), line -> new StringPair(line.substring(7, 10), line.substring(12, 15))));

    String END_LOCATION = "ZZZ";
    String currentLocation = "AAA";
    int numberOfSteps = 0;
    while (!currentLocation.equals(END_LOCATION)) {
      int rlIndex = numberOfSteps % rlInstructions.length;
      if (rlInstructions[rlIndex] == 'R') {
        currentLocation = rlMaps.get(currentLocation).right();
      } else {
        currentLocation = rlMaps.get(currentLocation).left();
      }
      numberOfSteps++;
    }
    return numberOfSteps;
  }
}
