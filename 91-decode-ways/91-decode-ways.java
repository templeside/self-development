class Solution {
    public int numDecodings(String s) {
            // <key, count>
        Map<Integer, Integer> memoArr = new HashMap<>();
        
        return memo(0,s, memoArr);
    }
    // idx는 iterator.
    // 오른쪽에서부터 memoization을 한다. how????
    public int memo(int idx, String str, Map<Integer, Integer> memoArr){
        if(memoArr.containsKey(idx))
            return memoArr.get(idx);
        
        if(idx == str.length()) return 1; // base case. return 1
        
        if(str.charAt(idx) =='0') return 0; // base case. return 0
        
        if(idx == str.length()-1) return 1; // base case. return 1
        
        
        int ans = memo(idx+1, str, memoArr); // 오른쪽에 있는 것 부터 memoization을 한다.
        if(Integer.parseInt(str.substring(idx, idx+2))<=26)
            ans += memo(idx+2, str, memoArr);      // 왜 index +2?? 이상이상.....
        
        memoArr.put(idx, ans);       // save for memoization
        
        return ans;
            
    }
}