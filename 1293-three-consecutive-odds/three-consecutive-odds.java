class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n = arr.length;

        //Approach 01 -> simple  
        // for(int i = 0 ; i < n - 2 ; i++){
        //     //if ith element even found then leave it 
        //     if(arr[i] % 2 == 0) continue;

        //     if(arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0){
        //         return true;
        //     }
        // }

        //aproach 02--> count consecutive streak
        int oddCountStreak = 0;
        for(int num : arr){
            if(num % 2 != 0){
                oddCountStreak++; 
                //if 3 consecutive odd found
                if(oddCountStreak == 3) return true;
            }else{
                oddCountStreak = 0;
            }
        }
        return false;
    }
}