class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequent = new int['Z'-'A'+1];        //26. char array length from A to Z 
        
        for(int c: tasks){
            frequent[c-'A']++;
        }
        
        int max = 0;
        for(int count: frequent){
            max = Math.max(max, count);
        }
        
        int numMax = 0;
        for(int count: frequent){
            if(max == count)
                numMax++;
        }
        return Math.max(tasks.length, (max-1)*(n+1)+numMax);
    }
}