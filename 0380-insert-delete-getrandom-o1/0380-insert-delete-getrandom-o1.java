class RandomizedSet {
    Random random;
    Map<Integer, Integer> indexMap;
    LinkedList<Integer> arr;
    public RandomizedSet() {
        random = new Random();
        indexMap = new HashMap<>();
        arr =new LinkedList<>();
    }
    
    public boolean insert(int val) {
        if(indexMap.containsKey(val))
            return false;
        arr.add(val);
        indexMap.put(val, arr.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!indexMap.containsKey(val))return false;
        int listIndex = indexMap.get(val);
        int lastVal = arr.get(arr.size()-1);
        
        indexMap.put(lastVal, listIndex);
        arr.set(listIndex, lastVal);
        
        arr.remove(arr.size()-1);
        indexMap.remove(val);
        return true;

    }
    
    public int getRandom() {
        int idx = random.nextInt(arr.size());
        return arr.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */