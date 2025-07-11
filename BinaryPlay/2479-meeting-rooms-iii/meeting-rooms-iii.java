// class NewCompare implements Comparator<long[]>{
//     public Long compare(long[] a , long[] b){
//         if(a[0] != b[0]){
//             return Long.compare(a[0] , b[0]);
//         }
//         return Long.compare(a[1] , b[1]);

//     }
// }

class Solution {
    public int mostBooked(int n, int[][] meetings) {

        int len = meetings.length; 

        /* Brute Force approach --> O(nlgn + n*m)
        //room number i will be last available at
        long[] lastRoomAvailableAt = new long[n]; 

        //count of rooms --> how many times they used
        long[] roomUseCount = new long[n];

        //sort meetings array by first time
        Arrays.sort(meetings , (a,b) -> a[0] - b[0]);  //O(n Logn)
         
        for(int i = 0 ; i < len ; i++){  //O(m)

            int endTime = meetings[i][1];
            int startTime = meetings[i][0];
            int duration = endTime - startTime;

            int roomEmptyFirst = 0;
            long earlyEndTime = Long.MAX_VALUE;
            boolean found = false;

            for(int room = 0 ; room < n ; room++){  // O(n)
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
        */

        //OPtimal Approach --> Using heap 
        
        //sort meetings array by first time
        Arrays.sort(meetings , (a,b) -> a[0] - b[0]);  //O(n Logn)

        var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        
        //Availability of rooms
        var unUsedRooms = new PriorityQueue<Integer>();

        for(int r = 0 ; r < n ; r++){
            unUsedRooms.offer(r);
        }

        //count of rooms --> how many times they used
        long[] roomUseCount = new long[n];

        for(int i = 0 ; i < len ; i++){

            int endTime = meetings[i][1];
            int startTime = meetings[i][0];
            int duration = endTime - startTime;

            //check in heap that any meeting that will end before starting ith meeting
            //pop it
            while(!usedRooms.isEmpty() && usedRooms.peek()[0] <= startTime){ 
                int room = (int) usedRooms.poll()[1]; 
                unUsedRooms.offer(room);
            }

            //if heap empty then check for availibityRoom 
            if(!unUsedRooms.isEmpty()){
                int room = unUsedRooms.poll();
                usedRooms.offer(new long[]{endTime , room});
                roomUseCount[room]++;
            }else{
                //available room nahi mila
                //then check for usedRoom jo sbse jaldi finish krde meeting ko
                if(!usedRooms.isEmpty()){
                    int room = (int)usedRooms.peek()[1];
                    long end = usedRooms.poll()[0];
                    usedRooms.offer(new long[]{(end + duration) , room});
                    roomUseCount[room]++;
                }
            }

        }        

        long maxRoomOccupied = 0;
        int roomNumber = -1;
        for(int i = 0 ; i < n ; i++){ // O(n)
            if(maxRoomOccupied < roomUseCount[i]){
                maxRoomOccupied = roomUseCount[i];
                roomNumber = i;
            }  
            System.out.println(roomUseCount[i]);
        }
        return roomNumber;

    }
}