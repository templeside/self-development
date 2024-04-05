class Solution {
    /*
    since it should be consecutive, i might use sliding window
    
    I do keep track of the size of hashmap.
        increment:
            update the size of the hashmap
        decrement:
            size of hashmap>2
    update the maxTotalFruit
    */
    public int totalFruit(int[] fruits) {
        int maxTotalFruit = 0;
        Map<Integer, Integer> map = new HashMap();
        int n = fruits.length;
        int end = 0;
        
        for(int start=0; start<n; start++){
            int fruit = fruits[start];
            map.put(fruit, map.getOrDefault(fruit,0)+1);
            
            while(map.size()>2){
                int endFruit = fruits[end];
                map.put(endFruit, map.get(endFruit)-1);
                if(map.get(endFruit)== 0)
                    map.remove(endFruit);
                end++;
            }
            
            maxTotalFruit = Math.max(start-end+1, maxTotalFruit);
        }
        return maxTotalFruit;
    }
}