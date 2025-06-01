class Solution {
    public String reversePrefix(String word, char ch) {
         int index = word.indexOf(ch); // Step 1: Find the index of first occurrence of ch

        if (index == -1) {
            return word; // Step 2: If ch not found, return original word
        }

        // Step 3: Reverse the substring from 0 to index
        StringBuilder prefix = new StringBuilder(word.substring(0, index + 1)).reverse();
        
        // Step 4: Append the rest of the string
        String suffix = word.substring(index + 1);

        return prefix.toString() + suffix;
    }
}