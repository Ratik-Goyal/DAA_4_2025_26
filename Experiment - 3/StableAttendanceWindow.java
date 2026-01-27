import java.util.*;
public class StableAttendanceWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of days: ");
        int n = sc.nextInt();

        System.out.println("Enter attendance for each day (P for Present, A for Absent):");
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        map.put(0, -1);
        for (int i = 0; i < n; i++) {

            System.out.print("Day " + (i + 1) + ": ");
            char ch = sc.next().charAt(0);

            if (ch == 'P') {
                sum++;
            } else {
                sum--;
            }

            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        System.out.println("Longest stable attendance window length: " + maxLen);
    }
}
