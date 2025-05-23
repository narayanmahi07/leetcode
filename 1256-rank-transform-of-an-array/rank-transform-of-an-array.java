class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();        // Step 1: Clone original array

        Arrays.sort(sorted);     // Step 2: Sort the clone

        Map<Integer,Integer> rankmap = new HashMap<>();
        int rank = 1;


 // Step 3: Assign ranks to unique values

        for(int num : sorted){
            if(!rankmap.containsKey(num)){
                rankmap.put(num,rank);
                rank++;
            }
        }
         // Step 4: Replace elements with ranks
        for(int i = 0 ; i<arr.length;i++){
            arr[i] = rankmap.get(arr[i]);
        }
        return arr;
    }
}




/*\U0001f4a1 Approach:
Sort and deduplicate the array to get all unique values.

Map each unique value to its rank using a HashMap.

Replace each element in the original array with its rank.

*/



/*✅ Java Code with Detailed Line-by-Line Explanation
java
Copy
Edit
import java.util.*;
\U0001f539 This imports all the utility classes from Java (like HashMap, Arrays, List, etc.) that we’ll use.

java
Copy
Edit
public class RankTransform {
\U0001f539 We define a public class named RankTransform. It's the container for our method.

java
Copy
Edit
    public int[] arrayRankTransform(int[] arr) {
\U0001f539 This is the main method that:

Takes an integer array arr as input.

Returns a new array where each element is replaced by its rank.

java
Copy
Edit
        int[] sorted = arr.clone();
\U0001f539 We make a copy of the original array so we can sort it without changing the input.

✅ clone() ensures the original array stays untouched (initially).

java
Copy
Edit
        Arrays.sort(sorted);
\U0001f539 Sort the copied array in ascending order.

\U0001f539 This helps us rank the values: smallest → rank 1, next → rank 2, and so on.

java
Copy
Edit
        Map<Integer, Integer> rankMap = new HashMap<>();
\U0001f539 Create a HashMap to store each unique number and its rank.

\U0001f511 Key = original number, \U0001f3f7️ Value = its rank

java
Copy
Edit
        int rank = 1;
\U0001f539 Initialize rank counter starting from 1 (since ranks are 1-based).

java
Copy
Edit
        for (int num : sorted) {
\U0001f539 Loop through each element in the sorted array.

\U0001f501 Elements may repeat, so we must handle duplicates.

java
Copy
Edit
            if (!rankMap.containsKey(num)) {
\U0001f539 Check if this number has already been ranked (to skip duplicates).

java
Copy
Edit
                rankMap.put(num, rank);
\U0001f539 If it’s the first time we see the number, assign it the current rank.

java
Copy
Edit
                rank++;
\U0001f539 Move to the next rank for the next unique number.

java
Copy
Edit
            }
        }
\U0001f539 End of if and for loop for building the rankMap.

java
Copy
Edit
        for (int i = 0; i < arr.length; i++) {
\U0001f539 Now, loop through the original array again.

java
Copy
Edit
            arr[i] = rankMap.get(arr[i]);
\U0001f539 Replace each element in the original array with its rank using rankMap.

java
Copy
Edit
        return arr;
\U0001f539 Return the transformed array.

\U0001f9ea Example:
For arr = [40,10,20,30]:

plaintext
Copy
Edit
Sorted:    [10, 20, 30, 40]
Rank map:  {10=1, 20=2, 30=3, 40=4}
Output:    [4, 1, 2, 3]

 */