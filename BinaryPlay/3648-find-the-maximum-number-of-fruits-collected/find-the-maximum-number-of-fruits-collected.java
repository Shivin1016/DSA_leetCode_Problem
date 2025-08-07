class Solution {

    int n ;
    int[][] memo1 ;
    int[][] memo2;

    public int maxCollectedFruits(int[][] fruits) {
        
        n = fruits.length; 

        //for child1 -> it only can move on diagonal elements becuase if it go on other cells then in (n - 1) moves it can't reach to the (n - 1 , n - 1) cell
        //hence child1 can only move on diagonal cell
        int c1 = child1Collection(fruits); 

        //it can only moves within (i < j) points --> means can't go other side of diagonal
        memo1 = new int[n + 1][n + 1];
        for(int i = 0 ; i <= n ; i++) Arrays.fill(memo1[i] , -1);

        int c2 = child2Collection(0 , n - 1 , fruits);

        //it can only moves within (i > j) points --> means can't go other side of diagonal
        memo2 = new int[n + 1][n + 1];
        for(int i = 0 ; i <= n ; i++) Arrays.fill(memo2[i] , -1);
        int c3 = child3Collection(n - 1 , 0 , fruits);

        return c1 + c2 + c3;
    }

    public int child1Collection(int[][] fruits){
        int total = 0;
        for(int i = 0 ; i < n ; i++){
            //collect only diagonal elements
            total += fruits[i][i];
        }
        return total;
    }

    public int child2Collection(int i , int j , int[][] fruits){

        //base case
        if(i >= n || j < 0 || j >= n) return 0;

        if(i == n - 1 && j == n - 1){
            return 0 ; //becasue this fruit already taken by c1
        } 

        //constraint for c2
        if(i > j || i == j){ // agr apne diagonal se dusre diagonal side chala ya phir diagonal element par pahuch jaye 
            return 0;
        }

        if(memo1[i][j] != -1) return memo1[i][j];

        //(i , j) ->(i + 1 , j - 1) bottom left
        int bottom_left = fruits[i][j] + child2Collection(i + 1 , j - 1 , fruits);

        //(i , j) ->(i + 1 , j) bottom down
        int bottom_down = fruits[i][j] + child2Collection(i + 1 , j , fruits);

        //(i , j) ->(i + 1 , j + 1) bottom right
        int bottom_right = fruits[i][j] + child2Collection(i + 1 , j + 1 , fruits);

        return memo1[i][j] = Math.max(bottom_left , Math.max(bottom_down , bottom_right));
    }

    public int child3Collection(int i , int j , int[][] fruits){

        // base case
        if(i < 0 || i >= n || j >= n){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            return 0 ; // already taken by c1
        }

        //constaint for c3 --> apne diagona; side ke opposite side chala jaye agr 
        if(i < j || i == j) return 0;

        if(memo2[i][j] != -1) return memo2[i][j];

        //top right (i , j) --> (i - 1 , j  + 1)
        int top_right = fruits[i][j] + child3Collection(i - 1 , j + 1 , fruits);

        // top up (i , j) --> (i , j + 1)
        int top_up = fruits[i][j] + child3Collection(i , j + 1 , fruits);

        // bottom right (i , j) --> (i + 1 , j + 1)
        int bottom_right = fruits[i][j] + child3Collection(i + 1 , j + 1 , fruits);

        return memo2[i][j] = Math.max(top_right , Math.max(top_up , bottom_right));
    }
}