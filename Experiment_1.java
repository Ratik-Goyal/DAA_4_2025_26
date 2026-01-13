// 1. Recurrance Relation = 3T(n / 2) + (n * log n)
// 2. Time Complexity = T(n) = O(n ^ log 3 with base 2)
// 3. Given Below:- 
import java.util.*;
public class Experiment_1 {
    static long Count = 0;
    static int max = 0;

    static void complexRec(int n, int depth) {
        max = Math.max(max, depth);
        
        if (n <= 2) {
            return;
        }

        int p = n;
        while (p > 0) {
            int[] temp = new int[n];
            for (int i = 0; i < n; i++) {
                temp[i] = i ^ p;
               Count++;
            }
            p >>= 1;
            Count++;
        }

        int[] small = new int[n];
        for (int i = 0; i < n; i++) {
            small[i] = i * i;
            Count++;
        }

        reverseArray(small);
        complexRec(n / 2, depth);
        complexRec(n / 2, depth);
        complexRec(n / 2, depth);
    }

    private static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
            Count++;
        }
    }

    public static void main(String[] args) {
        int[] test = {8, 22, 34, 137};
        for (int n : test) {
            Count = 0;
            max = 0;
            long startTime = System.currentTimeMillis();
            complexRec(n, 0);
            long endTime = System.currentTimeMillis();
            
            System.out.println("n = " + n);
            System.out.println("Operations: " + Count);
            System.out.println("Max Depth: " + max);
            System.out.println("Time: " + (endTime - startTime) + " ms");
            System.out.println();
        }
    }
}