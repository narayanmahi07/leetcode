class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        } 
        int start = 0, end = n-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            // edge cases 
            if(mid == 0 && nums[mid] != nums[mid+1]) return nums[mid];
            if(mid == n-1 && nums[mid] != nums[mid-1]) return nums[mid];
            if(mid > 0 && mid < n-1 && nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];

           // Determine which side to search
            if(mid % 2 == 0) { // even index
              if(nums[mid] == nums[mid+1]){
                start = mid +2;
              }
              else{
                  end = mid -1;
              }
            }

            else {  // odd index
            if(nums[mid] == nums[mid - 1]) {
                start = mid +1;
            }
            else{
                end = mid -1;
            }

            }

            

        }
        return -1;
    }
}