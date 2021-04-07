import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Puzzles {
    public ArrayList<Integer> getAbove10(int[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        int sum = 0;
        for(int value : arr) {
            sum += value;
            if(value > 10) {
                newArr.add(value);
            }
        }
        System.out.println(sum);
        return newArr;
    }
    public ArrayList<String> getAbove5Chars(ArrayList<String> arr) {
        arr.add("Nancy");
        arr.add("Jinichi");
        arr.add("Fujibayashi");
        arr.add("Momochi");
        arr.add("Ishikawa");

        Collections.shuffle(arr);

        ArrayList<String> newArr = new ArrayList<String>();

        for(String value : arr) {
            if(value.length() > 5) {
                newArr.add(value);
            }
            System.out.println(value);
        }
        return newArr;
    }
    public ArrayList<Character> shuffleAlph(char[] alphArr) {
        ArrayList<Character> arr = new ArrayList<Character>();

        for(char value : alphArr) {
            arr.add(value);
        }

        Collections.shuffle(arr);

        char first = arr.get(0);
        char last = arr.get(arr.size() - 1);

        System.out.println(last);
        System.out.println(first);
        if(first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
            System.out.println("This is a message");
        }
        return arr;
    }
    public ArrayList<Integer> randomNums() {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random r = new Random();

        for(int i=0; i<10; i++) {
            arr.add(r.nextInt(45) + 55);
        }
        System.out.println(arr);
        return arr;
    }
    public ArrayList<Integer> randomNumsSorted() {
        ArrayList<Integer> arr = randomNums();
        Collections.sort(arr);
        System.out.println(arr.get(0));
        System.out.println(arr.get(arr.size() - 1));
        return arr;
    }
    public String randomString(char[] letterArr) {
        ArrayList<Character> arr = new ArrayList<Character>();
        String output = "";
        Random r = new Random();

        for(char value : letterArr) {
            arr.add(value);
        }
        for(int i = 0; i < 5; i++) {
            output += arr.get(r.nextInt(25));
        }
        return output;
    }
    public ArrayList<String> randomStrings10(char[] letterArr) {
        ArrayList<String> arr = new ArrayList<String>();
        for(int i=0; i < 10; i++) {
            arr.add(randomString(letterArr));
        }
        System.out.println(arr);
        return arr;
    }
}