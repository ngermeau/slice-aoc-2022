import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {

    private final static String INPUT_FILE = "input.txt";
    private static ArrayList<Character>[] stacks;
    private static List<Move> moves;
    public record Move(int rep, int source, int target){}

    public static String source() {
        try {
            Path filePath = Paths.get(INPUT_FILE);
            return Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void initStacks(String[] inputsLine){
        stacks = (ArrayList<Character>[]) new ArrayList[9];
        int stackEndLine = 8;
        for (int currentLine = 0; currentLine < stackEndLine; currentLine++) {
            for (int col = 1; col < inputsLine[currentLine].length(); col += 4) {
                if (inputsLine[currentLine].charAt(col) != ' ') {
                    int stackPointer = Math.round(col / 4);
                    if (stacks[stackPointer] == null) {
                        stacks[stackPointer] = new ArrayList<Character>();
                    }
                    stacks[stackPointer].add(inputsLine[currentLine].charAt(col));
                }
            }
        }
    }

    public static void initMoves(String[] inputsLine){
        String[] movesArray= Arrays.copyOfRange(inputsLine, 10, inputsLine.length);
        moves = Arrays.stream(movesArray).map(Day5::toMove).toList();
    }

    public static Move toMove(String inputLine){
        String[] move = (inputLine.replaceAll("[^0-9]+", " ").trim().split(" "));
        return new Move(Integer.parseInt(move[0]), Integer.parseInt(move[1]), Integer.parseInt(move[2]));
    }

    public static void printLastCrate(){
        System.out.println("");
        for (ArrayList<Character> stack : stacks) {
            System.out.print(stack.get(0) + " ");
        }
    }


    private static void movePart1(Move move) {
        for (int i = 0; i < move.rep ; i++){
            stacks[move.target - 1].add(0,stacks[move.source -1].get(0));
            stacks[move.source -1].remove(0);
        }
    }

    private static void movePart2(Move move) {
        List<Character> toBeMoved = stacks[move.source - 1].subList(0,move.rep);
        for (int i = toBeMoved.size() - 1; i >= 0; --i){
            stacks[move.target - 1].add(0,toBeMoved.get(i));
            toBeMoved.remove(i);
        }
    }

    public static void solve1(String[] inputsLine) {
        moves.forEach(Day5::movePart1);
        printLastCrate();
    }

    public static void solve2(String[] inputsLine) {
        moves.forEach(Day5::movePart2);
        printLastCrate();
    }
    public static void main(String[] args) {
        String[] inputsLine = source().split("\n");
        initStacks(inputsLine);
        initMoves(inputsLine);
        solve1(inputsLine);
        initStacks(inputsLine);
        solve2(inputsLine);
    }
}
