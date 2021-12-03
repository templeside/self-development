class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1idx = m-1;
        int n2idx=  n-1;
        
        for(int sumIdx = m+n-1; sumIdx>=0; sumIdx--){
            if(n2idx<0)break;
            else if( n1idx>=0 && nums1[n1idx] > nums2[n2idx]){
                nums1[sumIdx] = nums1[n1idx];
                n1idx--;
            }else{
                nums1[sumIdx] = nums2[n2idx];
                n2idx--;
            }
                
            
        }
        
    }
}