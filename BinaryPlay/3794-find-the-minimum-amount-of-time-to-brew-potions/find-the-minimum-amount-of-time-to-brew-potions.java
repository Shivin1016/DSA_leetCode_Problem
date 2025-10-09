class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;

        long[] finishTime = new long[n];

        for(int j = 0 ; j < m ; j++){ //iterate over each potion
            finishTime[0] += mana[j] * skill[0];

            for(int i = 1 ; i < n ; i++){  //for each wizard     
                finishTime[i] = Math.max(finishTime[i - 1] , finishTime[i]) + skill[i] * mana[j];
            }

            // sychronize each wizard -> so that starts immediatly when potion free and wizard free
            for(int i = n - 1 ; i > 0 ; i--){
                finishTime[i - 1] = finishTime[i] - (skill[i] * mana[j]);
            }
        }
        return finishTime[n - 1];
    }
}