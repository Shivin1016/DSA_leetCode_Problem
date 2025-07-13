class Solution { 
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {

        int left = firstPlayer;
        int right = secondPlayer;

        if(left == n - right + 1){
            // they are at edge for competite
            return new int[]{1 , 1};
        }

        //left > n - right + 1
        if(left > n - right + 1){
            //change p1 and P2 as they are symmetric
            int temp = n - left + 1;
            left = n - right + 1;
            right = temp;
        } 

        int earliest = Integer.MAX_VALUE;
        int latest = 0;
        int nextRoundRemainingPlayer = (n + 1) / 2;

        // left --> p1 player
        // right --> p2 player 
        if(right <= nextRoundRemainingPlayer){
            //case 1--> both on left hand side of half of n 
            int survivorsLeftCount = left - 1;
            int survivorsMidCount = right - left - 1;

            //p1 position depend --> survivors to left of p1
            for(int surviLeft = 0 ; surviLeft <= survivorsLeftCount ; surviLeft++){
                //p2 position depend -->survivors in middle of p1 and p2 
                for(int surviMid = 0 ; surviMid <= survivorsMidCount ; surviMid++){

                    //left(p1) position for next round
                    int nextRoundp1Pos = surviLeft + 1;
                    //right(p2) position for next round
                    int nextRoundp2Pos = nextRoundp1Pos + surviMid + 1;

                    //recustion call
                    int[] newPos = earliestAndLatest(nextRoundRemainingPlayer , nextRoundp1Pos , nextRoundp2Pos);
                    //update answers
                    earliest = Math.min(newPos[0] + 1 , earliest);
                    latest = Math.max(newPos[1] + 1 , latest);
                }
            } 
        }else{
            //case 2--> both on opposite side of half of n 
            int fightsRight = n - right + 1; // find compitotr for right(p2) player

            int survivorLeftCount = left - 1;
            int survivorMidCount = fightsRight - left -1;
            int remainingSurvivorCnt = right - fightsRight - 1;

            for(int surviLeft = 0 ; surviLeft <= survivorLeftCount ; surviLeft++){
                for(int surviMid = 0 ; surviMid <= survivorMidCount ; surviMid++){
                    //left(p1) position for next round
                    int nextRoundPosLeft = surviLeft + 1;
                    //right(p2) position for next round
                    int nextRoundPosRight = nextRoundPosLeft + surviMid + ((remainingSurvivorCnt + 1) / 2) + 1;

                    int[] newPos = earliestAndLatest(nextRoundRemainingPlayer , nextRoundPosLeft , nextRoundPosRight);
                    //update answers
                    earliest = Math.min(newPos[0] + 1 , earliest);
                    latest = Math.max(newPos[1] + 1 , latest);
                }
            }
        }

        return new int[]{earliest , latest};

    }
}