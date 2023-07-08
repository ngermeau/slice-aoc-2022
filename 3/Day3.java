import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 {

  private static String INPUT_FILE = "input.txt";

  public static String source() {
    try {
      Path filePath = Paths.get(INPUT_FILE);
      return Files.readString(filePath);
    } catch (IOException e) {
      throw new RuntimeException();
    }
  }

  private static int toPoints(Character character) {
    if (Character.isUpperCase(character)) {
      return character - 38;
    }
    return character - 96;
  }

  /**
   * @param bagpack
   * @return
   */
  private static int calcErrorPart1(String bagpack) {
    String compartmentOne = bagpack.substring(0, bagpack.length() / 2);
    String compartmentTwo = bagpack.substring(bagpack.length() / 2);
    Set<String> compartmentOneItems = new HashSet<>(Arrays.asList(compartmentOne.split("")));
    Set<String> compartmentTwoItems = new HashSet<>(Arrays.asList(compartmentTwo.split("")));
    compartmentOneItems.retainAll(compartmentTwoItems);

    char theError = (((String) compartmentOneItems.toArray()[0]).charAt(0));
    return toPoints(theError);
  }

  private static int calcErrorPart2(List<String> bagpacks) {
    Set<String> bagpackOne = new HashSet<>(Arrays.asList(bagpacks.get(0).split("")));

    for (String bagpack : bagpacks) {
      Set<String> nextBagpack = new HashSet<>(Arrays.asList(bagpack.split("")));
      bagpackOne.retainAll(nextBagpack);
    }
    char theBadge = (((String) bagpackOne.toArray()[0]).charAt(0));
    return toPoints(theBadge);
  }

  private static int part1() {
    return Arrays.stream(source().split("\n"))
        .mapToInt(rucksack -> calcErrorPart1(rucksack))
        .sum();
  }

  private static int part2() {
    String[] bagpacks = source().split("\n");
    int points = 0;
    for (int i = 0; i < bagpacks.length; i += 3) {
      points += calcErrorPart2(Arrays.asList(bagpacks[i], bagpacks[i + 1], bagpacks[i + 2]));
    }
    return points;
  }
  public static void main(String[] args) {
    System.out.println(part1());
    System.out.println(part2());
  }

}
