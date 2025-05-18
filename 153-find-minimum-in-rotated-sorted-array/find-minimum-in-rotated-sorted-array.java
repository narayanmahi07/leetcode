class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right, the min is on the right side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Otherwise, the min is at mid or to the left
                right = mid;
            }
        }

        // When left == right, we have found the smallest value
        return nums[left];
    }
}
