class Solution {
//              <current index,  count number>
    public Map<Integer,Integer> memo = new HashMap<>();
    public int numDecodings(String s) {
        return findRecursive(0,s);
    }
    
    private int findRecursive(int idx, String str){
        if(memo.containsKey(idx))
            return memo.get(idx);
        if(idx == str.length())
            return 1;
        if(str.charAt(idx) == '0')
            return 0;
        if(idx == str.length()-1)
            return 1;
        
        int ans = findRecursive(idx+1, str);
        if(Integer.parseInt(str.substring(idx, idx+2))<=26)
            ans += findRecursive(idx+2, str);
        
        memo.put(idx, ans);
        return ans;
    }
}