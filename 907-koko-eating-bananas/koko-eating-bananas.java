class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = getMax(piles);
        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canFinish(piles, h, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0; // ✅ Fix: Use long to prevent overflow
        for (int pile : piles) {
            hours += (pile + k - 1L) / k; // add L to prevent intermediate overflow
        }
        return hours <= h;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int p : piles) {
            if (p > max) {
                max = p;
            }
        }
        return max;
    }
}
