public class Run {
    public static void main(String[] args) {
        StringManipulator manipulator = new StringManipulator();
        String  resultA = manipulator.trimAndConcat("     Fizz     ", "     Buzz     ");
        Integer resultB = manipulator.getIndexOrNull("FizzBuzz", 'L');
        Integer resultC = manipulator.getIndexOrNull("FizzBuzz", 'u');
        Integer resultD = manipulator.getIndexOrNull("FizzBuzz", "Buzz");
        String  resultE = manipulator.concatSubString("ffFizzZZ", 2, 6, "Buzz");
        System.out.println(resultA + '\n' + resultB + '\n' + resultC + '\n' + resultD + '\n' + resultE);
    }
}