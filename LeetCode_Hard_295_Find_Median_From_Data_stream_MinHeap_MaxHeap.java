import java.util.PriorityQueue;

class MedianFinder {
    
    // Max Heap to store the smaller half of the numbers (left side of median)
    private PriorityQueue<Integer> leftMaxHeap; 
    
    // Min Heap to store the larger half of the numbers (right side of median)
    private PriorityQueue<Integer> rightMinHeap; 

    public MedianFinder() {
        // Max Heap: Stores the smaller half of the numbers
        // Since PriorityQueue is a min-heap by default, we invert the order to make it a max heap
        leftMaxHeap = new PriorityQueue<>((a, b) -> b - a); 
        
        // Min Heap: Stores the larger half of the numbers
        // Default PriorityQueue is a min heap (smallest element on top)
        rightMinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        // Step 1: Always insert into the max heap (left half)
        leftMaxHeap.offer(num);

        // Step 2: Ensure balance by moving the largest from max heap to min heap
        rightMinHeap.offer(leftMaxHeap.poll());

        // Step 3: Rebalance if the right heap is bigger than the left heap
        if (leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        // Step 4: If the left max heap is larger, the median is the top of the max heap
        if (leftMaxHeap.size() > rightMinHeap.size()) {
            return leftMaxHeap.peek();
        } 
        // Step 5: If both heaps are equal in size, the median is the average of the two middle values
        else {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
    }
}

/**
 * Imagine you're running a real-time median calculator and need to find the median as numbers are added dynamically.
Use two heaps:
Max Heap (left) stores the smaller half of numbers.
Min Heap (right) stores the larger half of numbers.
The trick is:
Keep both halves balanced so that the median is always at the top of one or between the tops of both heaps.
Always insert into the Max Heap first, then balance by moving elements to the Min Heap.
If the right heap gets bigger, move one element back to the left heap to ensure balance.


Step By Step: 
Insert into the max heap (left side) first.
Balance: Move the largest element from the left heap to the right heap.
Rebalance: If the right heap gets bigger, move one element back to the left heap.
Find Median:
If the left heap is bigger, return its top (since it's the middle).
If both heaps are equal, return the average of both tops.
 */
