class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];

        // Step 1: Create diff array from queries
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];

            diff[start] += 1;
            if (end + 1 < n) {
                diff[end + 1] -= 1;
            }
        }

        // Step 2: Compute cumulative updates
        int[] result = new int[n];
        int cumSum = 0;
        for (int i = 0; i < n; i++) {
            cumSum += diff[i];
            result[i] = cumSum;
        }

        // Step 3: Check if each nums[i] can be zeroed
        for (int i = 0; i < n; i++) {
            if (result[i] < nums[i]) return false;
        }

        return true;
    }
}
