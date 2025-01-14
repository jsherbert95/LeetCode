class Solution {
    public int romanToInt(String s) {
        
        int answer = 0; 
        int currentNumber = 0;

        //begin the switch iteration from the right to left 
        //IV 
        for(int i = s.length() -1; i>= 0; i--){
            //Switch
            switch(s.charAt(i)){
                case 'I': currentNumber = 1; break;
                case 'V': currentNumber = 5; break;
                case 'X': currentNumber = 10; break;
                case 'L': currentNumber = 50; break;
                case 'C': currentNumber = 100; break;
                case 'D': currentNumber = 500; break;
                case 'M': currentNumber = 1000; break;
            }
            if(4 * currentNumber < answer){
                answer -= currentNumber;
            }
            else{
                answer += currentNumber;
            }
        }
        return answer;
    }
}

/**
EFFICIENT SOLUTION NOTES: 
Switch from a HashMap O(1) to Switch O(1) because lack of overhead for hash computation and ta ble management 

The condition 4 * num < answer works because it identifies when subtraction is needed in Roman numerals. Here's a simplified explanation:

Subtraction in Roman Numerals:

Subtraction happens when a smaller numeral (like I, X, or C) appears before a larger numeral (e.g., IV = 4, IX = 9, CM = 900).
These subtractive cases occur when the current numeral (num) is much smaller than the total (answer).
Why 4 * num?:

Subtractive pairs in Roman numerals are designed so the smaller numeral is at most 1/5 of the larger numeral (e.g., I before V, or X before L).
Checking 4 * num < answer is a shorthand to detect these cases without explicitly comparing numeral pairs.
Logic:

If 4 * num < answer, subtract num from answer.
Otherwise, add num. */
