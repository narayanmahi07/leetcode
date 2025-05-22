class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] result = new int[nums.length];
        int evenindex =0;
        int oddindex = 1;

        for(int num : nums) {
            if(num % 2 ==0){
                result[evenindex] = num;
                evenindex +=2;
            }
            else{
                result[oddindex] = num;
                oddindex +=2;
            }
        }
        return result;
    }
}