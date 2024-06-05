import java.util.*;

public class One {
    
    public static int getMin(List<Integer> arr) {
        int n = arr.size();
        int count = 0;
        
        while (n > 1) {
            boolean found = false;
            
            for (int i = 0; i < n - 1; i++) {
                if (arr.get(i) > 0 && arr.get(i + 1) > 0) {
                    int newValue = Math.min(arr.get(i) % arr.get(i + 1), arr.get(i + 1) % arr.get(i));
                    arr.set(i, newValue);
                    arr.remove(i + 1);
                    n--;
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                break;
            }
            
            count++;
        }
        
        return count + n;
    }
    
    public static void main(String[] args) {
        // Example 1
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(2, 4, 6, 8));
        System.out.println(getMin(arr1)); // Expected output: 2
        
        // Example 2
        List<Integer> arr2 = new ArrayList<>(Arrays.asList(1, 1, 2, 3));
        System.out.println(getMin(arr2)); // Expected output: 2
    }
}
