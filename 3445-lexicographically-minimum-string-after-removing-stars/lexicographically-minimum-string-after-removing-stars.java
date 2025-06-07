class P {
    public char c;
    public int i;

    public P(char c, int i) {
        this.c = c;
        this.i = i;
    }

}

class Solution {
    public String clearStars(String s) {

        int n = s.length();

        int starCnt = 0; //check starCount if it is zero then return string as it is
        for (char ch : s.toCharArray()) {
            if (ch == '*')
                starCnt++;
        }
        if (starCnt == 0)
            return s;

        PriorityQueue<P> pq = new PriorityQueue<>((a, b) -> {
            if (a.c == b.c) {
                return b.i - a.i;
            }
            return Character.compare(a.c, b.c);
        });
        char[] str = s.toCharArray();
        for (int i = 0; i < n; i++) {

            char ch = str[i];

            if (ch != '*') {
                //pop min char from minHeap
                pq.add(new P(ch, i));
            } else {
                P p = pq.poll();
                str[p.i] = '*';
            }
        }

        String ans = ""; 
        for(char ch : str) {
            if (ch != '*') {
                ans += ch;
            }
        }

        return ans;

    }
}