class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 1, high = maxSum, result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBuild(mid, n, index, maxSum)) {
                result = mid;        // Try a bigger value
                low = mid + 1;
            } else {
                high = mid - 1;      // Try a smaller value
            }
        }

        return result;
    }

    // Check if we can put `peak` at index and build the array under maxSum
    private boolean canBuild(int peak, int n, int index, int maxSum) {
        long left = getSum(peak - 1, index);          // left side sum
        long right = getSum(peak - 1, n - index - 1); // right side sum
        long total = left + right + peak;             // total including peak
        return total <= maxSum;
    }

    // Helper to calculate sum on one side (left or right)
    private long getSum(int peak, int len) {
        if (peak >= len) {
            // Build decreasing sequence till 1 (or more), e.g., [4,3,2,1]
            long first = peak - len + 1;
            long last = peak;
            return (first + last) * len / 2;
        } else {
            // Peak too small, use 1s after decreasing sequence
            long full = (long)(peak + 1) * peak / 2;
            long remaining = len - peak;
            return full + remaining;
        }
    }
}



/*\U0001f4d8 Line-by-Line Explanation:
int left = 1, right = maxSum
→ The peak value at index must lie between 1 and maxSum

Binary Search:
→ For each mid, check if it can be a valid value at index.

isValid(mid, n, index, maxSum)
→ Compute total array sum assuming peak = mid

calcSideSum(peak - 1, index)
→ Calculate the decreasing values on one side of the peak
→ If peak is high enough to cover the entire side, use arithmetic sum
→ If not, use decreasing values + padding 1s

total = left + right + peak
→ Total sum of array

⏱ Time & Space Complexity:
Time: O(log(maxSum)) × O(1) → Efficient!

Space: O(1)

\U0001f9ea Dry Run:
Input: n = 4, index = 2, maxSum = 6
Try mid = 3 → [1, 2, 3, 2] → sum = 8 ❌
Try mid = 2 → [1, 2, 1, 1] → sum = 5 ✅
Answer = 2

✅ MCQs:
Which algorithm is primarily used in this solution?

a) DFS

✅ b) Binary Search

c) Sliding Window

d) BFS

What structure is formed around the index in the logic?

a) Valley

✅ b) Pyramid

c) Flat line

d) Circular Array

What is the time complexity of the solution?

a) O(n)

✅ b) O(log maxSum)

c) O(n log n)

d) O(1)

\U0001f4ac Interview Insight:
Q: Why can we use binary search here?

A: Because if a peak value x is valid, then any value less than x is also valid — forming a monotonic condition that binary search can exploit.*/