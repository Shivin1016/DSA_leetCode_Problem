class Solution {
    public int countCollisions(String directions) {
        int n = directions.length();

        int collisions = 0;
        char[] dir = directions.toCharArray();
        int rightCnt = 0;
        for(int i = 0 ; i < n ; i++){
            char ch = dir[i];

            if(ch == 'S'){
                continue;
            }

            if(ch == 'R' && i < n - 1){
                rightCnt++;
                boolean isCollide = false;
                if(dir[i + 1] == 'L'){
                    collisions += (rightCnt + 1);
                    isCollide = true;
                    dir[i + 1] = 'S';
                }else if(dir[i + 1] == 'S'){
                    collisions += rightCnt;
                    isCollide = true;
                }

                if(isCollide == true){
                    dir[i] = 'S';
                    rightCnt = 0;
                }

            }
            else if(ch == 'L' && i > 0){
                boolean isCollide = false;
                if(dir[i - 1] == 'R'){
                    collisions += 2;
                    dir[i - 1] = 'S';
                    isCollide = true;
                }else if(dir[i - 1] == 'S'){
                    collisions += 1;
                    isCollide = true;
                }

                if(isCollide == true) dir[i] = 'S';
            } 
        }

        return collisions;
    }
}