class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int mindiff = Integer.MAX_VALUE;

         // Step 1: Find min difference
         for(int i =1; i < arr.length;i++){
            mindiff = Math.min(mindiff , arr[i] - arr[i-1]);
         }
         // Step 2: Collect all pairs with minDiff
         for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] == mindiff){
                 result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
         }
         return result;
    }
}


/*✅ Full Code with Line-by-Line Explanation
java
Copy
Edit
import java.util.*; 
\U0001f539 This line imports Java utility classes — like List, ArrayList, and Arrays — that are used later in the program.

java
Copy
Edit
public class MinimumAbsDifference {
\U0001f539 This declares a public class named MinimumAbsDifference. It’s like a container for our method.

java
Copy
Edit
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
\U0001f539 This defines a method named minimumAbsDifference that:

Takes an array of integers as input (arr)

Returns a list of integer pairs (List<List<Integer>>), each representing a pair with minimum absolute difference.

java
Copy
Edit
        Arrays.sort(arr);
\U0001f539 Sorts the input array in ascending order.

✅ Why? Because the minimum difference will always be between adjacent elements in a sorted array.

java
Copy
Edit
        List<List<Integer>> result = new ArrayList<>();
\U0001f539 Creates an empty list named result to store all valid pairs with minimum absolute difference.

\U0001f4e6 It will look like: [[1, 2], [2, 3]] at the end.

java
Copy
Edit
        int minDiff = Integer.MAX_VALUE;
\U0001f539 Initializes minDiff with the largest possible integer value.

\U0001f9e0 It’s used to track the smallest difference between any two adjacent elements.

java
Copy
Edit
        for (int i = 1; i < arr.length; i++) {
\U0001f539 Starts a loop from the second element to the end of the array.

✅ Why start at 1? Because we compare each element to the one before it (i.e., arr[i] - arr[i-1]).

java
Copy
Edit
            minDiff = Math.min(minDiff, arr[i] - arr[i - 1]);
\U0001f539 Calculates the difference between adjacent elements.

\U0001f539 Updates minDiff if a smaller difference is found.

java
Copy
Edit
        }
\U0001f539 Ends the first loop.

java
Copy
Edit
        for (int i = 1; i < arr.length; i++) {
\U0001f539 Starts a second loop to collect all pairs that have the minDiff.

java
Copy
Edit
            if (arr[i] - arr[i - 1] == minDiff) {
\U0001f539 Checks if the current adjacent pair has the minimum difference.

java
Copy
Edit
                result.add(Arrays.asList(arr[i - 1], arr[i]));
\U0001f539 If yes, create a list with the two elements and add it to result.

\U0001f539 Arrays.asList() turns [a, b] into a list.

java
Copy
Edit
            }
        }
\U0001f539 Ends the second loop and the if block.

java
Copy
Edit
        return result;
\U0001f539 Returns the list of all pairs that have the minimum absolute difference.

\U0001f9ea Example Input:
java
Copy
Edit
arr = [4, 2, 1, 3]
\U0001f501 Sorted → [1, 2, 3, 4]
\U0001f4c9 minDiff → 1
\U0001f4e6 result → [[1, 2], [2, 3], [3, 4]]*/ 