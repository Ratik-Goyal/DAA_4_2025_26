public class Painter {
    static boolean canPaint(int[] arr, int k, int maxTime) {
        int painters = 1, time = 0;

        for (int len : arr) {
            if (time + len <= maxTime) {
                time += len;
            } else {
                painters++;
                time = len;
            }
        }
        return painters <= k;
    }

    public static int minTime(int[] arr, int k) {
        int low = 0, high = 0;

        for (int len : arr) {
            low = Math.max(low, len);
            high += len;
        }

        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canPaint(arr, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}