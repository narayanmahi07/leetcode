class Solution {
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove all non-alphanumeric characters
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        
        int i = 0; // Initialize the left pointer
        int j = s.length() - 1; // Initialize the right pointer
        
        while (i <= j) { // Loop until the pointers meet or cross
            if (s.charAt(i) != s.charAt(j)) { // Compare characters at the pointers
                return false; // If not equal, the string is not a palindrome
            }
            i++; // Move the left pointer to the right
            j--; // Move the right pointer to the left
        }
        
        return true; // If the loop completes without issues, it's a palindrome
    }
}
