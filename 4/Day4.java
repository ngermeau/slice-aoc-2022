import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Day4 {

  private static String INPUT_FILE = "input.txt";

  public static String source() {
    try {
      Path filePath = Paths.get(INPUT_FILE);
      return Files.readString(filePath);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
  public static int[] toInts(String pair){
    return (Arrays.stream(pair.replaceAll("[^0-9]+", " ")
            .split(" ")).mapToInt(Integer::parseInt).toArray());
  }
  public static boolean contains(int[] pairs){
    return (pairs[0] >= pairs[2] && pairs[1] <= pairs[3]) ||
              (pairs[0] <= pairs[2] && pairs[1] >= pairs[3]);
  }

  public static boolean overlap(int[] pairs){
    return (pairs[0] <= pairs[3] && pairs[1] >= pairs[2]);
  }

  public static long solve1() {
    String[] pairs = source().split("\n");
    return Arrays.stream(pairs).map(Day4::toInts).filter(Day4::contains).count();
  }

  public static long solve2() {
    String[] pairs = source().split("\n");
    return Arrays.stream(pairs).map(Day4::toInts).filter(Day4::overlap).count();
  }

  public static void main(String[] args) {
    System.out.println(solve1());
    System.out.println(solve2());
  }

}
