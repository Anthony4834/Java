import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 7, 9, 8, 13 ,25, 32};
        char[] letterArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        ArrayList<String> arr2 = new ArrayList<String>();
        Puzzles puzzles = new Puzzles();
        puzzles.getAbove10(arr);
        puzzles.getAbove5Chars(arr2);
        puzzles.shuffleAlph(letterArr);
        puzzles.randomNums();
        puzzles.randomNumsSorted();
        puzzles.randomString(letterArr);
        puzzles.randomStrings10(letterArr);
    }
}