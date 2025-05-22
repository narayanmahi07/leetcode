class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n-1;
        int pos = n-1;

        while(left <= right){
            int leftsq = nums[left] * nums[left];
            int rightsq = nums[right] * nums[right];

            if(leftsq > rightsq){
                result[pos]=leftsq;
                left++;
            }else{
                  result[pos] = rightsq;
                  right--;
            }
            pos--;
        }
       
        return result;
    }
}





/*Line-by-Line Explanation

int[] result = new int[n];
→ Output array to store sorted squares.

int left = 0, right = n - 1;
→ Two pointers from both ends.

int pos = n - 1;
→ Start placing biggest square values from the back.

while (left <= right) { … }
→ Continue until both pointers cross.

int leftSq = nums[left] * nums[left];
→ Square of the left value.

int rightSq = nums[right] * nums[right];
→ Square of the right value.

if (leftSq > rightSq)
→ Larger square goes to result[pos], and move that pointer.

🧪 Dry Run

Example: nums = [-7, -3, 2, 3, 11]

left = 0, right = 4, pos = 4

squares: 49 vs 121 → place 121 at pos 4 → result = [0, 0, 0, 0, 121]

Move right to 3

left = 0, right = 3 → 49 vs 9 → place 49 at pos 3 → result = [0, 0, 0, 49, 121]

Move left to 1

left = 1, right = 3 → 9 vs 9 → pick right (or left), place 9 → result = [0, 0, 0, 49, 121]

and so on…

✅ Final result: [4, 9, 9, 49, 121]

🧠 Time & Space Complexity

Time: O(n)

Space: O(n) (output array)

📘 MCQs

Why do we use two pointers in this problem?

a) To sort the array

✅ b) To compare squares from both ends efficiently

c) To find min and max

d) To reduce space

What is the time complexity of this approach?

a) O(n log n)

✅ b) O(n)

c) O(n²)

d) O(1)

What is stored at result[n - 1]?

a) Minimum square

✅ b) Maximum square

c) Always 0

d) Random number

💬 Interview Insight

Q: Can we do this in-place?

A: No, because we may overwrite values before processing them. We need a separate result array to avoid data loss.*/
