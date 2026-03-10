import java.util.*;
class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        
        for(int i = 0; i <= arr.length - k; i++) {
            int max = arr[i];
            
            for(int j = 0; j < k; j++) {
                max = Math.max(max, arr[i + j]);
            }
            
            result.add(max);
        }
        
        return result;
    }
}