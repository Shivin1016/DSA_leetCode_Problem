class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int filled_Count = 0; 

        for(int i = 0 ; i < n ; i++){ 

            for(int j = 0 ; j < n ; j++){ 

                if(fruits[i] <= baskets[j]){ 
                    filled_Count++; 
                    baskets[j] = 0;
                    break;
                }
            }  
        }
        int remain = n - filled_Count;
        return remain;
    }
}