class Solution {
    public double average(int[] salary) {
        Arrays.sort(salary);

        int sum = 0;

        for(int i = 1 ; i < salary.length-1;i++){
            sum +=salary[i];
        }
        return (double) sum / (salary.length-2);
    }
}



/*Explanation of Each Line:
java
Copy
Edit
Arrays.sort(salary);
Sorts the array in ascending order, so smallest salary is at index 0, largest at last index.

java
Copy
Edit
int sum = 0;
Initialize a variable to hold the sum of salaries excluding min and max.

java
Copy
Edit
for (int i = 1; i < salary.length - 1; i++) {
    sum += salary[i];
}
Loop from the second element (index 1) to the second last element (index length-2) to exclude min and max.

Accumulate the sum.

java
Copy
Edit
return (double) sum / (salary.length - 2);
Calculate and return the average as a double.

Dry Run (salary = [4000, 3000, 1000, 2000])
After sorting: [1000, 2000, 3000, 4000]

Sum elements excluding first and last: 2000 + 3000 = 5000

Average: 5000 / 2 = 2500.0

Time and Space Complexity:
Time Complexity:
Sorting takes O(n log n)
Summation takes O(n)
Overall: O(n log n)

Space Complexity:
O(1) if sorting in-place.

*/