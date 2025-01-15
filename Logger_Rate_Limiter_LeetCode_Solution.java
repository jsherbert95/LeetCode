public class Logger {
    //Create a Queue to hold the current active log entries within the last 10 seconds.
    private Queue<String> currentActiveLogQueue;
    //Create a HashMap to hold the logs. We will remove the old (>10s ) to allow faster lookups, and keep memory useage low. 
    private HashMap<String, Integer> logs;
    public Logger() {
        this.currentActiveLogQueue = new LinkedList<>();
        this.logs = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        //Remove and trim the logs (via using the queue for faster access on recent log entries) and the queue (currentActiveLogQueue) with every call. This ensures heap memory is contained, and fast access for lookups.
        while(!currentActiveLogQueue.isEmpty()){
            String oldestMessage = currentActiveLogQueue.peek();
            //If the logs contain an entry that is outdated, remove it from the poll and the logs.
            if(logs.get(oldestMessage) + 10 <= timestamp){
                currentActiveLogQueue.poll();
                logs.remove(oldestMessage);
            }
            // Here we have hit the active log entries, so we break. 
            else{
                break;
            }
        }
        
        //If the logs dont contain the current Message add it.   Or, if the logs do contain the message, and the oldTimestamp+10 <= timestamp, add it.  
        if(!logs.containsKey(message) || logs.get(message) + 10 <= timestamp){
            logs.put(message, timestamp);
            currentActiveLogQueue.offer(message);
            return true;
        }
        else{
            return false;
        }
    }
}
/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */


// O(1)time, O(N) space, where N  = number of unique messages within 10 seconds 
//Jon
