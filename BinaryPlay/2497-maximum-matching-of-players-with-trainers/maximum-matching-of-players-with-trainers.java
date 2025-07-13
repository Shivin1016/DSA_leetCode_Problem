class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {

        // number of players
        int n = players.length;
        //number of trainers
        int m = trainers.length;

        //Approach 01 --> using Queue
        /*
        //Time Complexity --> O(n*logn + m + n*logm) --> O(n*logn*m)
        //Space Complexity -> O(m) 
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
        */

        //Approach 02 --> using sorting to both arrays
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0 , j = 0;
        int maxMatching = 0;
        while(i < n && j < m){
            if(players[i] > trainers[j]){
                j++;
            }

            if(j < m && players[i] <= trainers[j]){
                i++;
                j++;
                maxMatching++;
            }
        }

        return maxMatching;

    }
}