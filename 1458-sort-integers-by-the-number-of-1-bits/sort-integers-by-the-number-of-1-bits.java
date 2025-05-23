class Solution {
    public int[] sortByBits(int[] arr) {
     // Step 1: Box the int[] array into Integer[] for custom sorting
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        // Step 2: Sort with custom comparator
        Arrays.sort(boxed, (a, b) -> {
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);

            if (bitA != bitB) {
                return bitA - bitB;  // primary: sort by 1's count
            } else {
                return a - b;        // secondary: sort by value
            }
        });

        // Step 3: Unbox Integer[] back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }

        return arr;
    }
}


/*✅ Full Code:
java
Copy
Edit
import java.util.*;
✅ Imports all utility classes from the java.util package.

Needed for:

Arrays.sort()

Arrays.stream()

Integer[] manipulation

java
Copy
Edit
public class SortByBits {
✅ Declares a public class named SortByBits. It’s the class where our sorting method lives.

java
Copy
Edit
    public int[] sortByBits(int[] arr) {
✅ A public method named sortByBits that:

Takes an int[] array as input

Returns the sorted array as per the problem requirement

\U0001f537 Step 1: Box the int[] to Integer[]
java
Copy
Edit
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
✅ Arrays.stream(arr): Converts the int[] to an IntStream (a stream of primitive ints).

✅ .boxed(): Converts each primitive int to an Integer object (object wrapper).

✅ .toArray(Integer[]::new): Collects the stream into an Integer[] array.

❓ Why do we "box" the array?

Because Arrays.sort() with a custom comparator only works with objects like Integer, not primitives like int.

\U0001f537 Step 2: Sort with Custom Comparator
java
Copy
Edit
        Arrays.sort(boxed, (a, b) -> {
✅ Sort the boxed array using a lambda comparator.

a and b are two integers being compared during sorting.

java
Copy
Edit
            int bitA = Integer.bitCount(a);
            int bitB = Integer.bitCount(b);
✅ Integer.bitCount(x) returns the number of 1’s in the binary representation of x.

Stores:

bitA = number of 1’s in binary of a

bitB = number of 1’s in binary of b

java
Copy
Edit
            if (bitA != bitB) {
                return bitA - bitB;  // primary: sort by 1's count
✅ If a and b have a different number of 1’s:

Return difference → sorts by ascending number of 1’s.

e.g. 3 (011) → 2 1s, 2 (010) → 1 1 → so 2 comes before 3

java
Copy
Edit
            } else {
                return a - b;        // secondary: sort by value
            }
✅ If both numbers have the same number of 1’s:

Sort them by their actual numeric value (ascending).

e.g. 5 and 6 → both have two 1’s → 5 comes before 6.

java
Copy
Edit
        });
✅ Ends the custom comparator block.

\U0001f537 Step 3: Unbox Integer[] back to int[]
java
Copy
Edit
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
✅ Convert Integer[] back into int[] by:

Looping through boxed

Storing each element into original arr

\U0001f51a Return Final Result
java
Copy
Edit
        return arr;
    }
}
✅ Return the sorted int[] array.

The array is now sorted by:

Number of 1’s in binary

Actual value (if tied)

\U0001f9ea Example:
Input:

java
Copy
Edit
arr = [0, 1, 2, 3, 4, 5, 6, 7, 8]
Binary representation & 1's count:

yaml
Copy
Edit
0 → 0000 → 0
1 → 0001 → 1
2 → 0010 → 1
3 → 0011 → 2
4 → 0100 → 1
5 → 0101 → 2
6 → 0110 → 2
7 → 0111 → 3
8 → 1000 → 1
Sorted by rule → [0, 1, 2, 4, 8, 3, 5, 6, 7]

✅ Summary:
Step	Purpose
Boxing	To use custom sorting on primitive int
Custom Comparator	Sort by bit count, then by value
Unboxing	Convert result back to primitive int[] */