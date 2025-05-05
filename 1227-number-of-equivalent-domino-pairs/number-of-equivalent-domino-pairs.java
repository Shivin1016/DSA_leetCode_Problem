class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int pairs = 0 ;
        // first approach -> Brute Force approach ---> Gives Time limit exceeded

        //apporach 02 ---> using map 
        // Map<String , Integer> mp = new HashMap<>();
        // for(int i = 0 ; i < n ; i++){
        //     int a = dominoes[i][0];
        //     int b = dominoes[i][1];
           
        //     if(a > b){ 
        //         //swap 
        //         int temp = a ;
        //         a = b ;
        //         b = temp;
        //     }
        //     String st = a + "," + b;
        //     mp.put(st , mp.getOrDefault(st , 0) + 1);
        // }

        // for(int val : mp.values()){
        //     pairs += (val *(val - 1)) / 2;
        // }
        // return pairs;

        //Approach 03 --> using constant space
        int[] mp = new int[100];

         for(int i = 0 ; i < n ; i++){
            int a = dominoes[i][0];
            int b = dominoes[i][1];
           
            if(a > b){ 
                //swap 
                int temp = a ;
                a = b ;
                b = temp;
            }
            int num = a * 10 + b; 
            mp[num]++;
        }

        for(int i = 0 ; i < mp.length ; i++){
            pairs += (mp[i] * (mp[i] - 1)) / 2;
        }

        return pairs;

    }
}