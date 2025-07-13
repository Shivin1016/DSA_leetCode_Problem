class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // number of players
        int n = players.length;
        //number of trainers
        int m = trainers.length;

        //sort plyars in Ascending order
        Arrays.sort(players);

        //store trainers in pq
        var pq = new PriorityQueue<Integer>();
        for(int trainer : trainers){
            pq.add(trainer);
        }

        int maxMatching = 0;
        for(int player : players){
            
            if(pq.isEmpty()){
                break;
            }

            while(!pq.isEmpty()){
                int trainer = pq.poll(); 
                if(player <= trainer){
                    maxMatching++;
                    break;
                }
            }

        }

        return maxMatching;

    }
}