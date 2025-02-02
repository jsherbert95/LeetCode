class Solution {
    public String numberToWords(int num) {
        // Special case: if the number is zero, return "Zero" directly
        if (num == 0)
            return "Zero";

        // Arrays to store English representations of numbers
        String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
        String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
        String[] thousands = { "", "Thousand", "Million", "Billion" }; // Represents the number's magnitude scale

        // StringBuilder to construct the final English representation
        StringBuilder result = new StringBuilder();
        int groupIndex = 0; // Keeps track of the scale (thousands, millions, billions)

        // Process the number in chunks of three digits (thousands grouping)
        while (num > 0) {
            // Extract the last three digits of the number
            if (num % 1000 != 0) { // Process only non-zero groups
                StringBuilder groupResult = new StringBuilder();
                int part = num % 1000; // Extract the last three digits

                // Convert the hundreds place to words
                if (part >= 100) {
                    groupResult.append(ones[part / 100]).append(" Hundred ");
                    part %= 100; // Reduce to two-digit number
                }

                // Convert the tens and ones place
                if (part >= 20) { // Handles numbers 20 and above
                    groupResult.append(tens[part / 10]).append(" ");
                    part %= 10; // Reduce to ones place
                }
                
                // Convert the ones place (including numbers between 1-19)
                if (part > 0) {
                    groupResult.append(ones[part]).append(" ");
                }

                // Append the appropriate scale (thousand, million, etc.)
                groupResult.append(thousands[groupIndex]).append(" ");

                // Insert this group at the beginning to maintain proper numerical order
                result.insert(0, groupResult);
            }
            //Note we are still in the while loop, and outside of the first if statement. 

            num /= 1000; // Move to the next group of three digits
            groupIndex++; // Move to the next scale
        }

        // Trim and return the final English representation
        return result.toString().trim();
    }
}
