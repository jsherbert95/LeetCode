class Solution {
    public String reverseWords(String s) {
        // Step 1: Remove leading and trailing spaces and split the string into words
        // - `trim()` removes unnecessary leading and trailing whitespace.
        // - `split("\\s+")` uses a regex to split the string into words, ignoring multiple spaces.
        String[] words = s.trim().split("\\s+");

        // Step 2: Use StringBuilder to efficiently reverse the words
        StringBuilder sb = new StringBuilder();

        // Iterate over the words array in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]); // Append the current word
            if (i > 0) sb.append(" "); // Add a space between words (but not at the end)
        }
        // Step 3: Return the final reversed string
        return sb.toString();
    }
}
        // Explanation of `\\s+`:
        // - `\\s`: Matches any whitespace character, including spaces, tabs (`\t`), and newlines (`\n`).
        // - `+`: Matches one or more occurrences of the preceding pattern.
        // This ensures that groups of whitespace (like multiple spaces) are treated as a single delimiter.
// https://www.youtube.com/@jsherbert95 for tutorials on other leetcode problems. 
