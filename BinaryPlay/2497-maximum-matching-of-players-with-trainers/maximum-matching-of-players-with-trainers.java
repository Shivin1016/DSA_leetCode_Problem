class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        // number of players
        int n = players.length;
        //number of trainers
        int m = trainers.length;

        //sort plyars in Ascending order
        Arrays.sort(players); // O(n lgn)

        //store trainers in pq
        var pq = new PriorityQueue<Integer>();
        for(int trainerCapacity : trainers){ //O(m)
            pq.add(trainerCapacity);
        }

        int maxMatching = 0;
        for(int playerAbility : players){ //O(n)

            if(pq.isEmpty()){
                break;
            }

            while(!pq.isEmpty()){ //O(logm)
                int trainerCapacity = pq.poll(); 
                if(playerAbility <= trainerCapacity){
                    maxMatching++;
                    break;
                }
            }

        }

        return maxMatching;

    }
}