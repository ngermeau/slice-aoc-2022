import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

public class Day2 {

  private static String INPUT_FILE = "input.txt";

  private static Map<Character, Integer> expectedGameResultScoreMap = Map.of('X', 0, 'Y', 3, 'Z', 6);
  private static Map<Character, Integer> shapeScoreMap = Map.of('X', 1, 'Y', 2, 'Z', 3);
  private static Map<String, Integer> roundScoreMap = Map.of("A Y", 6, "B Z", 6, "C X", 6,
      "A X", 3, "B Y", 3, "C Z", 3,
      "A Z", 0, "B X", 0, "C Y", 0);

  public static String source() {
    try {
      Path filePath = Paths.get(INPUT_FILE);
      return Files.readString(filePath);
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  public static int calcRoundPointsPart1(final String round) {
    return shapeScoreMap.get(round.charAt(2)) + roundScoreMap.get(round);
  }

  public static int calcRoundPointsPart2(final String round) {
    final int expectedPoint = expectedGameResultScoreMap.get(round.charAt(2));
    String roundToPlay = roundScoreMap.entrySet().stream()
        .filter(e -> e.getKey().charAt(0) == round.charAt(0) &&
            e.getValue() == expectedPoint)
        .toList().get(0).getKey();
    return calcRoundPointsPart1(roundToPlay);
  }

  public static int part1() {
    return Arrays.stream(source().split("\n"))
        .mapToInt(round -> calcRoundPointsPart1(round))
        .sum();
  }

  public static int part2() {
    return Arrays.stream(source().split("\n"))
        .mapToInt(round -> calcRoundPointsPart2(round))
        .sum();
  }

  public static void main(String[] args) {
    System.out.println(part1());
    System.out.println(part2());
  }
}
