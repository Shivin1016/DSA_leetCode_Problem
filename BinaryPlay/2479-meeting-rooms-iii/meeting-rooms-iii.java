class NewCompare implements Comparator<int[]>{
    public int compare(int[] a , int[] b){
        if(a[1] != b[1]){
            return Integer.compare(a[1] , b[1]);
        }
        return Integer.compare(a[0] , b[0]);

    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        int len = meetings.length;

        //room number i will be last available at
        long[] lastRoomAvailableAt = new long[n]; 

        //count of rooms --> how many times they used
        long[] roomUseCount = new long[n];

        //sort meetings array by first time
        Arrays.sort(meetings , (a,b) -> a[0] - b[0]); 
         
        for(int i = 0 ; i < len ; i++){  

            int endTime = meetings[i][1];
            int startTime = meetings[i][0];
            int duration = endTime - startTime;

            int roomEmptyFirst = 0;
            long earlyEndTime = Long.MAX_VALUE;
            boolean found = false;

            for(int room = 0 ; room < n ; room++){  
                //Two Possibilites Are there --> either empty or filled if filled then check endTime
                if(lastRoomAvailableAt[room] <= startTime){
                    //empty hai --> to direct meeting ko assign kr do
                    roomUseCount[room]++; // increase count of currentRoom
                    lastRoomAvailableAt[room] = endTime; // assign time when the room gets empty
                    found = true;
                    break;
                }

                //agr koi room free nhi mila then check that sbse pahele kon sa room khali ho jayega
                if(earlyEndTime > lastRoomAvailableAt[room]){
                    earlyEndTime = lastRoomAvailableAt[room];
                    roomEmptyFirst = room;
                }
            }
        
            if(!found){
                //jo room sbse pahele finish hoga usko currentMeeting assign kr do
                //aur phir jo cuurent meeting start hogi endTime se
                lastRoomAvailableAt[roomEmptyFirst] = earlyEndTime + duration;
                roomUseCount[roomEmptyFirst]++;
            }
        }

        long maxRoomOccupied = 0;
        int roomNumber = 0;
        for(int i = 0 ; i < n ; i++){
            if(maxRoomOccupied < roomUseCount[i]){
                maxRoomOccupied = roomUseCount[i];
                roomNumber = i;
            } 
        }
        return roomNumber;

    }
}