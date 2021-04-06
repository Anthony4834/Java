public class FizzBuzz {
    public String fizzBuzz(int num) {
        String output = "";
        if(num % 3 == 0) {
            output += "Fizz";
        } 
        if(num % 5 == 0) {
            output += "Buzz";
        }
        if(output != "") {
            return output;
        } else {
            return String.valueOf(num);
        }
    }
}