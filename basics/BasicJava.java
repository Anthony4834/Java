import java.util.ArrayList;

public class BasicJava {
    public void print1To255() {
        for(int i=1; i <= 255; i++) {
            System.out.println(i);
        }
    }
    public void printOdd1To255() {
        for(int i=1; i <= 255; i += 2) {
            System.out.println(i);
        }
    }
    public void printSum() {
        int sum = 0;
        for(int i=1; i <= 255; i++) {
            sum += i;
            System.out.println(String.format("Number: [%s] Sum: [%s]", i, sum));
        }
    }
    public void loopThruArr(int[] arr) {
        for(int value : arr) {
            System.out.println(value);
        }
    }
    public int findMaxInArr(int[] arr) {
        int max = 0;
        for(int value : arr) {
            if(value > max) { max = value; }
        }
        System.out.println(max);
        return max;
    }
    public int findAverageInArr(int[] arr) {
        int sum = 0;
        for(int value : arr) {
            sum += value;
        }
        System.out.println(sum / arr.length);
        return sum / arr.length;
    }
    public ArrayList<Integer> createArrOfOdds() {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=1; i <= 255; i += 2) {
            arr.add(i);
        }
        System.out.println(arr);
        return arr;
    }
    public int findValuesOverNum(int[] arr, int num) {
        int output = 0;
        for(int value : arr) {
            if(value > num) {
                output += 1;
            }
        }
        System.out.println(output);
        return output;
    }
    public ArrayList<Integer> squareValuesInArr(int[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for(int value : arr) {
            newArr.add(value * value);
        }
        System.out.println(newArr);
        return newArr;
    }
    public ArrayList<Integer> DeleteNegativesInArr(int[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        for(int value : arr) {
            if(value > 0) {
                newArr.add(value * value);
            } else {
                newArr.add(0);
            }
        }
        System.out.println(newArr);
        return newArr;
    }
    public double[] findMinMaxAverage(int[] arr) {
        double[] values = {1.0/0.0, 0, 0}; //min: infinity, max: 0, average: 0
        int sum = 0;
        for(int i=0; i < arr.length; i++) {
            if(arr[i] < values[0]) {
                values[0] = arr[i];
            } 
            if(arr[i] > values[1]) {
                values[1] = arr[i];
            }
            sum += arr[i];
        }
        values[2] = sum / arr.length;
        return values;
    }
    public int[] shiftToFront(int[] arr) {
        int temp = arr[0];
        for(int i=1; i < arr.length; i += 1) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }
}