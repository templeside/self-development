class Solution {
    public int shipWithinDays(int[] weights, int days) {
  	// ex. [1,2,3,4,5,6,7,8,9,10] 5일만에 배달
        int left=0; // left boundary is maximum weight-한개씩 나를때- 최소 capacity=10
        int right=0;// right boundary is total sum of weights-한번에 나를때- 최대 capacity=55
        for(int w: weights){
            left=Math.max(left,w);
            right +=w;
        }
        
        // binary search capacity 10~55사이 제일 적절한 capacity 찾기
        while(left<right){
            int mid=left+(right-left)/2; // 중간 숫자 32
            int need=1;// 현재 median capacity 가지고 짐 옮기려면 얼마나 걸리는지
            int curr=0;//cumulative weight sum until current median=32 
            
            for(int w:weights){
                if(curr+w>mid){
                    need+=1; //how many days with this capacity - capacity=32는 이틀 걸림
                    curr=0;
                }
                curr+=w;
            }
            
            //현재 median capacity 가지고 걸리는 날짜가 given days인지 확인후 조율
            if(need>days){
                left=mid+1;// more capacity needed 날짜가 넘어서
            }
            else{ // need 2 <= 5 days
                right=mid;// less capacity needed 날짜가 같거나 남아서 -> median=32,need=2,update right 55>32
            }
        }
        
        return left;
        
    }
}
