class Solution {
    /*
    save prev <Value, Index> for the hashmap.
    while iteration, add find the remainder target - currValue(numbers[i])
    
    if found, reutrn value with index.
    */
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<numbers.length; i++){
            int diff = target-numbers[i];
            if(map.containsKey(diff))
                return new int[]{map.get(diff)+1, i+1};
            
            map.put(numbers[i], i);
        }
        return new int[]{};
    }
}