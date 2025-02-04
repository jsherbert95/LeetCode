class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumResult = new ArrayList<>();

        // Step 1: Sort the array to make it easier to detect duplicates and apply the two-pointer approach. Sorting allows us to see if we have duplicate numbers by checking the prior number to current. 
        Arrays.sort(nums);

        // Step 2: Iterate through each number in the array, treating it as the first number of a triplet
        for (int i = 0; i < nums.length - 2; i++) {
            
            //  **Skip duplicate values for the first element (nums[i])**
            // If the current number is the same as the previous one, we skip it.
            // This avoids finding the same triplet multiple times.
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int targetSum = -nums[i]; // The other two numbers must sum to this value    == I + J + K = 0     -I + 0  = J + K 
            int left = i + 1;          // Left pointer starts right after i
            int right = nums.length - 1; // Right pointer starts at the last index

            // Step 3: Use the two-pointer technique to find pairs that sum to targetSum
            while (left < right) {
                int currentSum = nums[left] + nums[right];

                if (currentSum == targetSum) {
                    //  Found a valid triplet, add it to the result list
                    threeSumResult.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //  **Skip duplicate values for the second element (nums[left])**
                    // If the next number is the same as the previous one, we skip to avoid duplicate triplets.
                    // Example: [-1, -1, 2] should be found only once, not multiple times.
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) left++; 

                    //  **Skip duplicate values for the third element (nums[right])**
                    // If the previous number is the same as the next one, skip to avoid duplicate triplets.
                    right--;
                    while (left < right && nums[right] == nums[right + 1]) right--;
                } 
                else if (currentSum < targetSum) {
                    // The sum is too small, move the left pointer forward to increase the sum
                    left++;
                } 
                else {
                    // The sum is too large, move the right pointer backward to decrease the sum
                    right--;
                }
            }
        }
        // Step 4: Return the list of all unique triplets
        return threeSumResult;        
    }
}

/**
Clarification: Why We Need to Skip Duplicates

Order doesn’t matter in a set.
A triplet {a, b, c} is considered the same as {a, c, b} or {c, a, b}.
So [-1, -1, 2] is the same as [-1, 2, -1]. We only want to count it once.

1️⃣ nums[i] ensures we don’t process the same starting number twice. We only process the first occurrence of -1 and skip consecutive duplicates.
if (i > 0 && nums[i] == nums[i - 1]) continue; 

2️⃣ Skipping Duplicates for nums[left] (Second Number)    
nums[left] ensures we don’t repeat the second number in the same triplet. If nums[left] is the same as the previous left,
while (left < right && nums[left] == nums[left - 1]) left++;

3️⃣Skipping Duplicates for nums[right] (Third Number)
nums[right] ensures we don’t repeat the third number in the same triplet. If nums[right] is the same as the next right, we decrement right to avoid duplicate triplets.
while (left < right && nums[right] == nums[right + 1]) right--;

 */
