class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        char[] ans = s.toCharArray();
        char[] vowels = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };

        Map<Character, Integer> frq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (isVowel(ans[i])) {
                frq.put(ans[i], frq.getOrDefault(ans[i], 0) + 1);
            }
        }

        int j = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(ans[i])) {
                //find vowel --> now find smallest one
                while (j < 10 && !frq.containsKey(vowels[j])) {
                    j++;
                }
                ans[i] = vowels[j];
                int left = frq.get(vowels[j]) - 1;
                if (left == 0)
                    frq.remove(vowels[j]);
                else {
                    frq.put(vowels[j], left);
                }
            }
        }
        return new String(ans);
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
                || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}