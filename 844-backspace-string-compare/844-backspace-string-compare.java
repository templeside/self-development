class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sIdx = s.length()-1;
        int tIdx = t.length()-1;
        
        while(sIdx>=0 || tIdx>=0){
            sIdx = findValid(s, sIdx);
            tIdx = findValid(t, tIdx);
            
            if(sIdx <0 && tIdx<0) return true;
            else if( sIdx<0 || tIdx<0)return false;
            else if( s.charAt(sIdx) != t.charAt(tIdx)) return false;
            
            sIdx--;
            tIdx--;
        }
        return true;
    }
    
    public int findValid(String s, int idx){
        int countBackspace = 0;
        while(idx>=0){
            if(s.charAt(idx)=='#') countBackspace++;
            else if( countBackspace>0) countBackspace--;
            else
                break;
            idx--;
        }
        return idx;
    }
}