class Solution {
    public int maxProduct(int[] nums) {
        int firstmax = 0;
        int secondmax = 0;

        for(int num : nums) {
            if(num > firstmax){
                secondmax = firstmax;
                firstmax = num;
            }
            else if(num > secondmax){
                secondmax = num;
            }
        }

        return (firstmax -1) * (secondmax -1);

    }
}

/* Explanation of Each Line:
java
Copy
Edit
public int maxProduct(int[] nums) {
Defines a function that takes an integer array nums.

java
Copy
Edit
    int firstMax = 0;
    int secondMax = 0;
Initialize two variables to keep track of the top two maximum numbers.

java
Copy
Edit
    for (int num : nums) {
Loop through each number in the array.

java
Copy
Edit
        if (num > firstMax) {
            secondMax = firstMax;
            firstMax = num;
        }
If current number is greater than firstMax:

Assign old firstMax to secondMax.

Update firstMax to current number.

java
Copy
Edit
        else if (num > secondMax) {
            secondMax = num;
        }
If current number is not the largest but greater than secondMax, update it.

java
Copy
Edit
    return (firstMax - 1) * (secondMax - 1);
Return the final product after subtracting 1 from both.

⏱️ Time and Space Complexity
Time Complexity: O(n) – One pass through the array

Space Complexity: O(1) – Only a few variables used*/