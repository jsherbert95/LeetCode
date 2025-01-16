//https://leetcode.com/problems/lru-cache/description/
class LRUCache {

    public HashMap<Integer,Integer> cache;
    public LinkedList<Integer> queue; 
    public int currentCapacity; 

    public LRUCache(int capacity) {
        cache = new HashMap<>();

        //Instead of using a linked list, utilize a double linked list, and add the most recently used element to the TAIL of the double linked list. This would allow for the least recently used, to be held at the HEAD of this list,
        //So we could pop off immediately, not traverse the list. 

        //Or, we could program our own double linked list here, utilizing node classes, and accessor methods.

        //Or, we could se the LinkedHashMap 
        queue = new LinkedList<>();
        currentCapacity = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        queue.remove((Integer) key);
        queue.offer(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        //Update the value if it exists.
        if(cache.containsKey(key)){
            cache.put(key, value);
            queue.remove((Integer) key);
            queue.offer(key);
        }
        //If the cache is full, remove the least recently used, (LinkedList is FIFO - first in, first out) so- the least recently used will always be first.   
        else{
            if (cache.size() == currentCapacity){
                cache.remove(queue.poll());
            }
            cache.put(key, value);
            queue.offer(key);
        } 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
