import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Day1 {
  private static String INPUT_FILE = "input.txt";

  public static String source() throws IOException {
    Path filePath = Paths.get(INPUT_FILE);
    return Files.readString(filePath);
  }

  public static IntStream totalPerElves() throws IOException {
    return Arrays.stream(source().split("\n\n"))
        .mapToInt(elve -> Arrays.stream(elve.split("\n"))
            .mapToInt(Integer::parseInt).sum());
  }

  public static int part1() throws IOException {
    return totalPerElves().max().getAsInt();
  }

  public static int part2() throws IOException {
    List<Integer> totalPerElves = totalPerElves().sorted()
        .boxed()
        .toList();

    return totalPerElves.get(totalPerElves.size() - 1) +
        totalPerElves.get(totalPerElves.size() - 2) +
        totalPerElves.get(totalPerElves.size() - 3);
  }

  public static void main(String[] args) throws Exception {
    System.out.println(part1());
    System.out.println(part2());
  }
}