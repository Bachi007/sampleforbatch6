import java.util.*;

public class Nikhil {

    public static int selectStock(int saving, List<Integer> currentValue, List<Integer> futureValue) {
        int maxProfit = 0;
        int n = Math.min(currentValue.size(), futureValue.size());

        for (int i = 0; i < n; i++) {
            int profit = futureValue.get(i) - currentValue.get(i);
            
            if (profit > 0) {
                int investment = Math.min(saving, currentValue.get(i));
                maxProfit += profit * investment / currentValue.get(i);
                saving -= investment;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1
        int saving1 = 500;
        List<Integer> currentValue1 = Arrays.asList(150, 199, 200, 168, 153);
        List<Integer> futureValue1 = Arrays.asList(140, 175, 199, 121, 111);
        System.out.println(selectStock(saving1, currentValue1, futureValue1)); // Expected output: 0

        // Test Case 2
        int saving2 = 30;
        List<Integer> currentValue2 = Arrays.asList(1, 2, 4, 6);
        List<Integer> futureValue2 = Arrays.asList(15, 3, 5, 6);
        System.out.println(selectStock(saving2, currentValue2, futureValue2)); // Expected output: 6

        // Test Case 3
        int saving3 = 449;
        List<Integer> currentValue3 = Arrays.asList(10, 125, 158, 1, 210, 104, 243, 238, 161, 227, 264, 10, 298, 268, 287, 84, 267, 64, 269, 284, 273, 96);
        List<Integer> futureValue3 = Arrays.asList(10, 243, 238, 161, 227, 264, 10, 298, 268, 287, 84, 267, 64, 269, 284, 273, 96);
        System.out.println(selectStock(saving3, currentValue3, futureValue3)); // Expected output: 745
    }
}
