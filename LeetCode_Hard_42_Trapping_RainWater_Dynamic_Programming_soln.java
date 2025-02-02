class Solution {
    public int trap(int[] height) {
        // Edge case: If the height array is empty, no water can be trapped.
        if(height.length == 0) return 0;

        int ans = 0;  // Variable to store the total trapped water.
        int size = height.length;  // Store the size of the height array.

        // Arrays to store the maximum height to the left and right of each index.
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        // Populate the leftMax array.
        leftMax[0] = height[0];  // The leftmost boundary has no left neighbor.
        // Iterate through the array from left to right.
        for(int i = 1; i < size; i++){
            // The leftMax at index i is the maximum height seen so far from the left.
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        // Populate the rightMax array.
        rightMax[size-1] = height[size-1];  // The rightmost boundary has no right neighbor.
        // Iterate through the array from right to left.
        for(int i = size-2; i >= 0; i--){
            // The rightMax at index i is the maximum height seen so far from the right.
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        // Calculate the trapped water.
        // We iterate through the height array, skipping the first and last index since they can't trap water.
        for(int i = 1; i < size-1; i++){
            // The trapped water at index i is determined by the minimum of leftMax[i] and rightMax[i]
            // minus the actual height at that index.
            ans += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }

        return ans;  // Return the total trapped water.
    }
}
