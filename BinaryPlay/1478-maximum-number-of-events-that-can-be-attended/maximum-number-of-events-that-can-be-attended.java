class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        
        int count = 0 ;

        Arrays.sort(events , (a, b) -> Integer.compare(a[0] , b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min heap -> as we want earlyiest end event

        int day = events[0][0];
        int i = 0;

        while(!pq.isEmpty() || i < n){  
            while(i < n && events[i][0] == day){
                pq.offer(events[i][1]);
                i++;
            } 

            if(!pq.isEmpty()){
                pq.poll();
                count++;
            }
            day++;
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
                

        } 

        return count;
    }
}