class Solution {

    /** We need to sum zero with an array of unique integers. Each unique integer has a unique negative counterpart, we can use that to sum and equal out each entry.
        If the given N variable is even, we can loop through with a counter(incremented after the positive and negative have been added) and assign its positive and negative value to array field.
        If the given N is odd, we do the same, but add in a 0 to account for this.  */
    public int[] sumZero(int n) {
        
        //Edge Case Scenario : If N is one, we need to just return a new int[] array containing 0.  
        //I am doing this check first because it will improve run time if given 1, we can immediately return the answer without doing any
        //calculations, logic, or creating unecessary variables (which are essentialy memory, and we want to be space concious and time concious)
        if (n == 1) return new int[] {0};

        int[] zeroArray = new int[n];
        //Check and see if n is even or odd, because if its odd then we would need to add a 0 in the array. 
        boolean isNEven = (n % 2 == 0);
        int counter = 2; 
        for(int i = 0; i < n; i++){
            //If i is Even, then we will add a unique positive number.
            if(i % 2 == 0){
                zeroArray[i] = counter;
            } // If i is Odd, then we will add the unique negative of that number
            else{
                zeroArray[i] = (-1 * counter++); // ++ is a post increment operator. It adds 1 to the variable, after the use of the variable in the expression.   counter = counter + 1; 
            }
        }
        if(!isNEven) zeroArray[n-1] = 0;
        return zeroArray;
    }
}
// n = 3;
//[2, -2, 3]

// Great job Gene!
