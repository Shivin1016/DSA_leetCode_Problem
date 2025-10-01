class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;

        while(empty >= numExchange){
            total += (numBottles / numExchange);
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
            empty = numBottles;
        }
        return total;
    }
}