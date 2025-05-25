import java.util.*;

public class Solution {
    public int[] frequencySort(int[] nums) {
        // Step 1: Create a frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert int[] to Integer[] for custom sorting
        Integer[] numsObj = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        // Step 3: Sort using custom comparator
        Arrays.sort(numsObj, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);

            if (freqA != freqB) {
                return freqA - freqB; // ascending frequency
            } else {
                return b - a; // descending value
            }
        });

        // Step 4: Convert back to int[] if needed
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }
}
