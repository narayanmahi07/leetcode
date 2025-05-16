class Solution {
    public int search(int[] nums, int target) {
        int left =0, right = nums.length-1;

        while(left <= right){
            int mid = left + (right - left)/2;
            

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }
}





🔵 Problem: 704. Binary Search

Given a sorted (ascending) array of integers and a target value, return the index of the target.
If the target is not found, return -1.

🔁 Binary Search is used when the array is sorted to find an element in O(log n) time.

🧠 Example:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
→ nums[4] = 9 ✅

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
→ 2 not in array ❌


📘 Line-by-Line Explanation:

Line	Explanation
int left = 0, right = nums.length - 1;	Initialize search range
while (left <= right)	Keep checking until range is exhausted
int mid = left + (right - left) / 2;	Calculate mid index (to prevent overflow)
if (nums[mid] == target) return mid;	Found the target, return index
else if (nums[mid] < target)	Target is on the right side
left = mid + 1;	Discard left half
else	Target is on the left side
right = mid - 1;	Discard right half
return -1;	Not found

🧪 Dry Run (Step-by-Step):

nums = [-1, 0, 3, 5, 9, 12], target = 9

Initial: left = 0, right = 5

→ mid = (0+5)/2 = 2 → nums[2] = 3 < 9 → move right → left = 3
→ mid = (3+5)/2 = 4 → nums[4] = 9 == target ✅
→ return 4

🧪 Another Dry Run:

nums = [-1, 0, 3, 5, 9, 12], target = 2

Initial: left = 0, right = 5
→ mid = 2 → nums[2] = 3 > 2 → move left → right = 1
→ mid = 0 → nums[0] = -1 < 2 → move right → left = 1
→ mid = 1 → nums[1] = 0 < 2 → move right → left = 2 > right → exit loop
→ return -1 ❌

🟨 Edge Cases:

Empty array → return -1

One element and it's the target → return 0

One element and it's not the target → return -1

Target not found at all → return -1

📙 MCQs

What is the time complexity of binary search?
a) O(n)
✅ b) O(log n)
c) O(n log n)
d) O(1)

Why do we write mid = left + (right - left) / 2?
a) Faster than (left+right)/2
✅ b) Prevents integer overflow
c) To work with float values
d) Just convention

What condition stops the loop?
✅ a) left > right
b) target < 0
c) mid == 0
d) nums.length == 0

💼 Interview Questions

Q1: Why binary search over linear search?
✅ Binary search is O(log n) vs O(n) in linear search – much faster for sorted data.

Q2: Can binary search be applied to unsorted arrays?
❌ No – binary search only works on sorted arrays.

Q3: Why not use (left + right) / 2 directly?
✅ For large values of left and right, (left + right) may overflow – use mid = left + (right - left) / 2.
