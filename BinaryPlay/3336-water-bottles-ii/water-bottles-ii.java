class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int drinkBottles = numBottles;
        int empty = numBottles;
        int fullBottles = 0;

        while(empty > 0){
            // second operation
            if(empty >= numExchange){
                empty -= numExchange;
                drinkBottles++;
                numExchange++;
                fullBottles++;
            }else{
                empty += fullBottles;
                if(empty < numExchange) break; // we cannot loop anymore
                fullBottles = 0;
            }
        }

        return drinkBottles;
    }
}