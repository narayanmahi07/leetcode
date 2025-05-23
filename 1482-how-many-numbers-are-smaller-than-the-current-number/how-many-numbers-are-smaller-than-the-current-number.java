class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int [] result = new int[n];

        for(int i = 0; i < nums.length ; i++){
            int count = 0;

            for(int j = 0 ; j < nums.length; j++){
                if(nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;

        }
        return result;
    }
}