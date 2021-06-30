class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> arrList = new ArrayList<>();
        for(int num: arr)
            arrList.add(num);
        
        Collections.sort(arrList, (a,b)-> Math.abs(a-x)-Math.abs(b-x));
        arrList = arrList.subList(0,k);
        Collections.sort(arrList);
        
        return arrList;
        
    }
}