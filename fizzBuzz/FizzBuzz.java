public class FizzBuzz {
    public String fizzBuzz(int num) {
        String output = "";
        if(num % 3 == 0) {
            output += "Fizz";
        } 
        if(num % 5 == 0) {
            output += "Buzz";
        }
        return output != "" ? output : String.valueOf(num);
    }
}