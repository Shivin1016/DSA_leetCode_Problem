class Solution { 
    int[][] t1 ;
    int[][] t2;
    public int solve1(int i , int j , int[][] fruits , int n ){
        if(i >= n || j >= n || j < 0  ){ 
            return 0;
        }

        if(t1[i][j] != -1) return t1[i][j];

        if(i == n - 1 && j == n - 1){
            return t1[i][j] = 0;// fruits already taken by child1
        }

        // if it goes opposite ke diagonal me y aon diagonal then return
        if(i > j || i == j){
            return t1[i][j] =  0;
        } 

        int bottom_left = fruits[i][j] +  solve1(i + 1 , j - 1 , fruits , n );
        int bottom_down = fruits[i][j] + solve1(i + 1 , j , fruits , n );
        int bottom_right = fruits[i][j] + solve1(i + 1 , j + 1 , fruits , n);

        return t1[i][j] = Math.max(bottom_left , Math.max(bottom_down , bottom_right));
    }
    public int solve2(int i , int j , int[][] fruits , int n ){

        if(i >= n || j >= n || i < 0 ){
        // System.out.println("Me=> " + moves);
            return 0;
        }
        if(t2[i][j] != -1) return t2[i][j];

        if(i == n - 1 && j == n - 1){
            return t2[i][j] = 0; // fruits already taken by child1
        } 

        if(i < j || i == j) return t2[i][j] = 0 ; // on diagonal or opposite diagonal 

        int top_right = fruits[i][j] +  solve2(i - 1 , j + 1 , fruits  , n    );
        int right = fruits[i][j] + solve2(i , j + 1 , fruits , n   );
        int bottom_right = fruits[i][j] + solve2(i + 1 , j + 1 , fruits , n    );

        return t2[i][j] = Math.max(top_right , Math.max(right , bottom_right));
    }

    public int maxCollectedFruits(int[][] fruits) {
        int N = fruits.length; 
        //for child1 -->it can only go diagonal on elements otherwise it can't react to n - 1 , n- 1 cell because of moves will go greater than n - 1

        int child1_collection1 = 0;
        for(int i = 0 ; i < N ; i++){
            child1_collection1 += fruits[i][i]; //aceess diagonals
            fruits[i][i] = 0 ;// nullify it , because it taken by child1
        }

        t1 = new int[N + 1][N + 1];
        for(int[]r : t1) Arrays.fill(r , -1);

        t2 = new int[N + 1][N + 1];
        for(int[]r : t2) Arrays.fill(r , -1);

        int child1_collection2 = solve1(0 , N - 1 , fruits ,N ); //moves = 0 in starting

        int child1_collection3 = solve2(N - 1 , 0 , fruits,N); 

        System.out.println(child1_collection2 + " " + child1_collection3);

        return child1_collection1 + child1_collection2 + child1_collection3;
    }
}