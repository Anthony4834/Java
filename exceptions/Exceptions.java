import java.util.ArrayList;

public class Exceptions {
    public static void main(String[] args) {
        ArrayList<Object> arr = new ArrayList<Object>();

        arr.add("13");
        arr.add("hello world");
        arr.add(48);
        arr.add("Goodbye World");

        System.out.println(arr);

        int failedToCast = 0;
        for(Object value : arr) {
            try {
                Integer casted = Integer.parseInt(String.valueOf(value));
            } catch (Exception e) {
                System.out.println(String.format("Couldn't cast %s", value));
                failedToCast += 1;
                continue;
            }
        }
        System.out.println("Failed to cast " + failedToCast + " Items");
    }
}