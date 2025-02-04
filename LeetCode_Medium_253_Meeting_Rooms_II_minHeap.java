import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // Edge case: If there are no meetings, no rooms are needed.
        if (intervals == null || intervals.length == 0) return 0; 

        // Step 1: Sort the meetings by their start times (earliest meeting first).
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Step 2: Use a Min-Heap (PriorityQueue) to track the end times of ongoing meetings.
        // The heap will always store the **earliest ending** meeting at the top.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int[] meeting : intervals) {
            // Step 3: If there's a meeting that has already ended before this one starts, 
            // free up a room (remove it from the heap).
            if (!minHeap.isEmpty() && minHeap.peek() <= meeting[0]) {
                minHeap.poll();
            }

            // Step 4: Add the current meeting's end time to the heap.
            minHeap.offer(meeting[1]);
        }

        // Step 5: The heap size represents the number of rooms required at peak usage.
        return minHeap.size();
    }
}


/**
Sorting the meetings by start time

This lets us process them in the order they begin, so we handle conflicts properly.
Using a Min-Heap (PriorityQueue) to track meeting end times

This ensures we always know the earliest meeting that will free up a room.
Checking minHeap.peek()

If the earliest finishing meeting (minHeap.peek()) is done before the current one starts, we remove it (poll()) to free up a room.
Adding meeting[1] to the heap

This marks the end time of the new meeting, meaning the room is occupied until then.
Heap size gives the answer

The maximum heap size at any point tells us the number of meeting rooms needed at peak usage.
**/
