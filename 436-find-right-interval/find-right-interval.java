import java.util.*;

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[] result = new int[n];

        // Step 1: Store (start, originalIndex)
        int[][] starts = new int[n][2];
        for (int i = 0; i < n; i++) {
            starts[i][0] = intervals[i][0]; // start value
            starts[i][1] = i;               // original index
        }

        // Step 2: Sort by start
        Arrays.sort(starts, Comparator.comparingInt(a -> a[0]));

        // Step 3: For each interval, find smallest start >= end using Binary Search
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            int low = 0, high = n - 1;
            int foundIndex = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (starts[mid][0] >= end) {
                    foundIndex = starts[mid][1]; // candidate
                    high = mid - 1; // try to find smaller start
                } else {
                    low = mid + 1;
                }
            }

            result[i] = foundIndex;
        }

        return result;
    }
}
