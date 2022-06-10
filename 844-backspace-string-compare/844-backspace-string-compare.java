class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sIdx = s.length()-1;
        int tIdx = t.length()-1;
        
        while(sIdx>=0 || tIdx>=0){
            sIdx = findValidPrev(sIdx,s);
            tIdx = findValidPrev(tIdx,t);
            
            if(sIdx<0 && tIdx<0)return true;
            else if(sIdx<0 || tIdx<0) return false;
            
            if(s.charAt(sIdx)!= t.charAt(tIdx))return false;
            
            sIdx--;
            tIdx--;
        }
        return true;
    }
    
    public int findValidPrev(int idx, String str){
        int backwardCount = 0;
        
        while(idx>=0){
            if(str.charAt(idx)=='#') backwardCount++;
            else if(backwardCount>0) backwardCount--;
            else break;
            idx--;
        }
        return idx;
    }
}