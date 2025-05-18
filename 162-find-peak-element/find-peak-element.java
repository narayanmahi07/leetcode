class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // Go right – there is a peak on the right
                left = mid + 1;
            } else {
                // Go left – current could be a peak
                right = mid;
            }
        }

        // At the end, left == right and pointing to a peak
        return left;
    }
}
