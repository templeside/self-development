class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        
        System.out.println("");
        
        ArrayList<int[]> ans = new ArrayList<>();
        
        for(int[] interval : intervals){            
            if( ans.size() !=0 && ans.get(ans.size()-1)[1] >=interval[0]){
                // int[]
                int[] prev = ans.get(ans.size()-1);       
                
                if(prev[1]>= interval[1])
                    continue;
                else
                    prev[1] = interval[1];
                
            }else{
                ans.add(interval);
            }
        }
        
        int[][] returnArr = new int[ans.size()][2];
        for(int i=0; i< ans.size();i++){
            returnArr[i] = ans.get(i);
        }
        
        return returnArr;
    }
}