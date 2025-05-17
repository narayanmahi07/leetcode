class Solution {
    public void sortColors(int[] nums) {
        int start = 0;               // Pointer for 0's
        int end = nums.length - 1;   // Pointer for 2's
        int index = 0;               // Current index

        while (index <= end) {
            if (nums[index] == 0) {
                swap(nums, index, start);  // Swap 0 to the start
                index++;
                start++;
            } else if (nums[index] == 2) {
                swap(nums, index, end);    // Swap 2 to the end
                end--; // Do not increment index here to recheck the swapped value
            } else {
                index++;  // Move past 1
            }
        }
    }
    
    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
