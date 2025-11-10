class RandomizedSet {
    Set<Integer> st;
    public RandomizedSet() {
        st = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(st.contains(val)) return false;
        st.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(st.contains(val)){
            st.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        List<Integer> randomList = new ArrayList(st);
        Random random = new Random();
        int randomIdx = random.nextInt(randomList.size());
        int val = randomList.get(randomIdx);
        return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */