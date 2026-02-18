class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }

        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = (left + right) / 2;
            long hours = 0;

            for (int pile : piles) {
                hours += pile / mid;
                if (pile % mid != 0) {
                    hours++;
                }
            }

            if (hours <= h) {
                right = mid - 1;
            } else {
                left = mid + 1;  
            }
        }

        return left;
    }
}