class Solution {
    /*
    intuition:
    for loop해서 앞뒤로 다 추가 해 버리자
    recursion(currlen-2, n):
        base case:
            if n== 0, return 0
            if n== 1, return 1, 8, 0
        
        recursion(currlen-2, n)
        curr = new arraylist
        
        from the recursion:
            add with current value
    */
    public List<String> findStrobogrammatic(int n) {
        return helper(n,n);    
    }

    private List<String> helper(int curLen, int n){
        if(curLen == 0) return new ArrayList(Arrays.asList(""));
        if(curLen == 1) return new ArrayList(Arrays.asList("1","8","0"));
        List<String> sub = helper(curLen-2, n);
        List<String> cur = new ArrayList();
        for(String s: sub){
            if(curLen != n){
                cur.add("0" + s + "0");
            }
            cur.add("6" + s + "9");
            cur.add("9" + s + "6");
            cur.add("8" + s + "8");
            cur.add("1" + s + "1");	
        }
        return cur;
    }
}