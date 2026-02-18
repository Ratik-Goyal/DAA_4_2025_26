import java.util.*;
public class Main {
    static int lowerbound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] < target) left = mid + 1;
        else right = mid;
    }
    return left;
}

static int upperbound(int[] arr, int target) {
    int left = 0; int right = arr.length;
    while(left < right) {
        int mid = left + (right - left) / 2;
        if(arr[mid] <= target) left = mid + 1;
        else right = mid;
    }
    return left;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }
    
    int m = sc.nextInt();
    int[] arr2 = new int[m];
    for(int i = 0; i < m; i++) {
        arr2[i] = sc.nextInt();
    }
    
    Arrays.sort(arr2);
    int target = sc.nextInt();
    int cnt = 0;
    
    for(int i : arr) {
        int diff = target - i;
        cnt += upperbound(arr2, diff) - lowerbound(arr2, diff);
    }
    
    System.out.println(cnt);
}
}