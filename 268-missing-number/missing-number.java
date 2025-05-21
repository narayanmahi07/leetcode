class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0; // To calculate the sum of elements in the array
        
        // Calculate the sum of elements in the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        // Calculate the expected sum of numbers from 0 to n
        int actualSum = nums.length * (nums.length + 1) / 2;
        
        // The missing number is the difference between the expected sum and the array sum
        int missingNumber = actualSum - sum;
        
        return missingNumber;
    }
}
