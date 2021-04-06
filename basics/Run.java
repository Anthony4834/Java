import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        int[] arr = {1, -3, 5, 7, -9, 13};
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        BasicJava basics = new BasicJava();
        basics.print1To255();
        basics.printOdd1To255();
        basics.printSum();
        basics.loopThruArr(arr);
        basics.findMaxInArr(arr);
        basics.findAverageInArr(arr);
        basics.createArrOfOdds();
        basics.findValuesOverNum(arr, 6);
        basics.squareValuesInArr(arr);
        basics.DeleteNegativesInArr(arr);
        basics.findMinMaxAverage(arr);
        basics.shiftToFront(arr);
    }
}