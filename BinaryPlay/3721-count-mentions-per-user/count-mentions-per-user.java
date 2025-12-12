class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) { 

        int[] mentions = new int[numberOfUsers];
        int[] offlineUsers = new int[numberOfUsers]; //store offline users 

        //sort events on basis of timestamps so that correct users can mentions
        Collections.sort(events , (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));
            if(t1 == t2){
                //if same timestamp then sort on basis of offline and message
                //firstly take offline  
                char c1 = a.get(0).charAt(0);
                char c2 = b.get(0).charAt(0);

                if(c1 > c2) return -1; // offline take first 
                if(c1 < c2) return 1;  

                return 0;
            }
            return t1 - t2;
        });

        for(List<String> event : events){
            String event_type = event.get(0);
            String time_stamp = event.get(1);
            int time = Integer.parseInt(time_stamp);
            String mentions_string = event.get(2);

            if(event_type.equals("MESSAGE")){
                if(mentions_string.equals("ALL")){ // for all users (online + offline)
                    for(int i = 0 ; i < numberOfUsers ; i++){
                        mentions[i]++;
                    }
                }else if(mentions_string.equals("HERE")){ //contains HERE -> only online users
                    //only count online users
                    for(int i = 0 ; i < numberOfUsers ; i++){ 
                        //offline users
                        // check for time 
                            if(offlineUsers[i] == 0 || offlineUsers[i] + 60 <= time){
                                //add 
                                mentions[i]++;  
                            } 
                        
                    }
                }else{ //contains idNumbers 
                    for(String idNum : mentions_string.split(" ")){
                        //extract id
                        int id = Integer.parseInt(idNum.substring(2)); 
                        //also mention offline users 
                        mentions[id]++;
                    }
                }
            }
            else if(event_type.equals("OFFLINE")){
                int id = Integer.parseInt(mentions_string); 
                offlineUsers[id] = time;
            }
        }

        return mentions;
    }
}