class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0, end = nums.length - 1;

        for (int num : nums) {
            if (num % 2 == 0) {
                result[start++] = num;  // Even numbers go to the front
            } else {
                result[end--] = num;    // Odd numbers go to the back
            }
        }

        return result;
    }
}
