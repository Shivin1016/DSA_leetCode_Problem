class Solution {
public:
    int n;
    int maxScore(vector<int>& nums) {
        n = nums.size();
        //for memoization
        unordered_map<vector<bool> , int> mp;
        //for visted marks
        vector<bool> visited(n , false); 

        return solve(nums , visited , 1 , mp);
    }

    int solve(vector<int>& nums , vector<bool>& visited , int op , unordered_map<vector<bool> , int>& mp){

        if(mp.find(visited) != mp.end()){
            return mp[visited];
        }

        int maxScore = 0;
        for(int i = 0 ; i < n - 1 ; i++){
            if(visited[i] == true) continue;
            for(int j = i + 1 ; j < n ; j++){
                if(visited[j] == true) continue;
                visited[i] = true;
                visited[j] = true;

                int currScore = op * __gcd(nums[i] , nums[j]);
                int remainScore = solve(nums , visited , op + 1 , mp);

                maxScore = max(maxScore , currScore + remainScore);

                visited[i] = false;
                visited[j] = false;
            }
        }

        return mp[visited] = maxScore;
    }
};