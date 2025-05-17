class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = findLeftBound(nums, target);
        int right = findRightBound(nums, target);

        return new int[]{left, right};
    }

    // Find the first occurrence (left bound) of the target
    private int findLeftBound(int[] nums, int target){
        int index = -1, low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                index = mid;
                high = mid - 1;  // keep searching in the left half
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return index;
    }

    // Find the last occurrence (right bound) of the target
    private int findRightBound(int[] nums, int target){
        int index = -1, low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                index = mid;
                low = mid + 1;  // keep searching in the right half
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return index;
    }
}
