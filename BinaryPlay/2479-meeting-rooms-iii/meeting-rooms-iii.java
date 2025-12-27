class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int m = meetings.length;

        //sort meetings on start time
        Arrays.sort(meetings , (a , b) -> a[0] - b[0]);

        //make minHeap to store all rooms ==> give rooms in O(logn)
        var freeRooms = new PriorityQueue<Integer>();

        for(int i = 0 ; i < n ; i++) freeRooms.add(i);

        //store frq for each room that how many times used
        int[] roomUsedCnt = new int[n];

        // endTime and Pairs store minHeap
        var usedRoomEndTime = new PriorityQueue<int[]>((a , b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
 

        for(int i = 0 ; i < m ; i++){
            int[] meeting = meetings[i];
            int startTime = meeting[0];
            int endTime = meeting[1];
            int duration  = endTime - startTime ;

            while(!usedRoomEndTime.isEmpty() && usedRoomEndTime.peek()[0] <= startTime){
                int room = usedRoomEndTime.poll()[1];
                freeRooms.add(room);
            }

            //now take room from freeRoms 
            if(!freeRooms.isEmpty()){
                int room = freeRooms.poll();
                //increased frq of used room
                roomUsedCnt[room]++;
                //and add this meeting end time in 
                usedRoomEndTime.add(new int[]{endTime , room});
            }else{  
                //take earlieast meeting that will free the room from usedRoom
                if(!usedRoomEndTime.isEmpty()){
                    int[] endTimeRoom = usedRoomEndTime.poll();
                    int room = endTimeRoom[1];
                    int end = endTimeRoom[0];

                    int newEndTime = end + duration;
                    usedRoomEndTime.add(new int[]{newEndTime , room});

                    roomUsedCnt[room]++;
                }
            }
        }

        //now take earlieast greater filled room
        int currRoomUsedCnt = Integer.MIN_VALUE;
        int room = 0;
        for(int i = 0 ; i < n ; i++){
            if(roomUsedCnt[i] > currRoomUsedCnt){
                currRoomUsedCnt = roomUsedCnt[i];
                room = i;
            }
        }

        return room ;


    }
}