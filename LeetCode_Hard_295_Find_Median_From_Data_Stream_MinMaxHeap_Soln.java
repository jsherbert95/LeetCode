class MedianFinder {

    private PriorityQueue<Integer> leftMaxHeap; // Max Heap (smaller left half) 
    private PriorityQueue<Integer> rightMinHeap; // Min Heap (Larger right half)
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a, b) -> b - a); //Max Heap.   B - a is max, by default, priority queue is a min heap. 
        rightMinHeap = new PriorityQueue<>(); // min heap. Default
    }
    
    public void addNum(int num) {
        leftMaxHeap.offer(num); //Insert into max heap. 
        //Balance it. Move from the left heap to the right heap.
        rightMinHeap.offer(leftMaxHeap.poll());
        //Rebalance. If the right heap gets bigger, rebalance. 
        if(leftMaxHeap.size() < rightMinHeap.size()) {
            leftMaxHeap.offer(rightMinHeap.poll());
        }
    }
    
    public double findMedian() {
        if (leftMaxHeap.size() > rightMinHeap.size()){
            return leftMaxHeap.peek();
        }
        else{
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
