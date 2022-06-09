class Solution {    
  public static void swap(int x, int y, int[] arr){
    int temp = arr[x];
    arr[x] = arr[y] ;
    arr[y] = temp;
  }
  public static void sortColors(int[] arr) {
    int left =0;
    int right=  arr.length-1;
    
    for(int i=0; i<=right;){
      if(arr[i] ==2){
        swap(i, right, arr);
        right--;
      }
      else if(arr[i] == 1){
        i++;
      }
      else{
        swap(i, left, arr);
        left++;
        i++;
      }
    }
  }
}