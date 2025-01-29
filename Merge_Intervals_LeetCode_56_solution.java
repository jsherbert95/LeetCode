// For a video tutorial and more in depth details and explanations, check out my YouTube channel here : h ttps://www.youtube.com/@jsherbert95
class Solution {
    public int[][] merge(int[][] intervals) {
        int startTime = 0;
        int endTime = 1;
        // Step 1: Sort intervals by their Start Time using Lambda Function and custom comparator since it is a double int[][] array. You could sort int[] arr; with Arrays.sort(arr);
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergedList = new ArrayList<>(); // Step 2: Use an ArrayList instead of a linkedlist for better  // access speed. Use linked list when you have more frequent writes  // and edits.
        int[] lastInterval = intervals[0]; // Track the last merged interval instead of utilizing method calls uneccessarily.
        mergedList.add(lastInterval);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            // Check if the current interval starts after the last interval. 
            if (currentInterval[startTime] > lastInterval[endTime]) {
                // No overlap of time, add the new interval
                mergedList.add(currentInterval);
                lastInterval = currentInterval; // update the last interval
            } else {
                // Merge the intervals by extending the end time. If the problem involves merging or updating overlapping intervals, always use Math.max to ensure values extend correctly. (LeetCode Problems:  56, 57, 435, 452).
                lastInterval[endTime] = Math.max(lastInterval[endTime], currentInterval[endTime]);
            }
        }
        // Convert List<int[]> to int[][]
        return mergedList.toArray(new int[mergedList.size()][]);

    }
}
/**
    Psuedo Code
    Sort the intervals.
    Create result list to store merged intervals. 
    Iterate over sorted intervals. 
    If the list is empty, or current doesnt overlap with last merged interval, add it to result list.
    Otherwise, merge the intervals by updating the end time of the last interval w/ Math.max
 */
