import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Day6 {

    private final static String INPUT_FILE = "input.txt";

    public static String source() {
        try {
            Path filePath = Paths.get(INPUT_FILE);
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String line = source().split("\n")[0];
        System.out.println(solve(line, 4));
        System.out.println(solve(line, 14));
    }

    private static int solve(String line, int markerSize) {
        String[] characters = line.split("");
        for (int i = markerSize; i < characters.length; ++i){
           List<String> sub = Arrays.stream(Arrays.copyOfRange(characters,i - markerSize,i)).toList();
           if (new HashSet<>(sub).size() == markerSize) { return i; }
        }
        throw new RuntimeException("marker not found");
    }
}
