class Solution {
    /**
    brute force: O(N^2)
    
    그거말고 더 좋은 방법은 없을까???? 
    comparing 하는 게 더 좋지 않을까???
    
    comparing curr, left increase, right increase???
    
    Input: 
    nums1 = [1,7,11], 
             ^
    nums2 = [2,4,6],
             ^
    k = 3
    
    smallest = [4,6, 7, 11]
    
    how do i know which one is which??
    
    can i just compare????
    
    안되지 왜냐하면 어떻게 더 적게 나올 수 있기 때문이지..
    
    time complexity 
    **/
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<int[]>((p1,p2)-> (p2[0] + p2[1]) - (p1[0]+ p1[1]));
        for(int i=0; i< nums1.length &&i<k; i++){
          for(int j=0; j< nums2.length && j<k; j++){
            if(minHeap.size() < k)
              minHeap.add(new int[]{nums1[i], nums2[j]});
            else{
              if(nums1[i] + nums2[j]> minHeap.peek()[0] + minHeap.peek()[1]) break;
              else{
                minHeap.poll();
                minHeap.add(new int[]{nums1[i], nums2[j]});
              }
            }
          }
        }
        // TODO: Write your code here    
        return new ArrayList(minHeap);
    }
}