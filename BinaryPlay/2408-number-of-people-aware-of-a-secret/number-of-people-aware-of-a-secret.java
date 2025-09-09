class Solution { 
    int m = 1000000007;
    int[] t ;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int total = 0;

        t = new int[1001];
        Arrays.fill(t , -1);

        for(int day = n - forget + 1 ; day <= n ; day++){
            if(day > 0){
                total = (total + solve(day , delay , forget)) % m;
            }
        }

        return total;
    }

    public int solve(int day , int delay, int forget){ // return number of person who know thw secret at day 
        if(day == 1) return 1; //only one person knew the secret

        if(t[day] != -1) return t[day];
        int result = 0;
        for(int d = day - forget + 1 ; d <= day - delay ; d++){
            if(d > 0){
                result = (result + solve(d , delay , forget)) % m;
            }
        }
        return t[day] =  result;

    }
}