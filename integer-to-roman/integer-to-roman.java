class Solution {
    public String intToRoman(int num) {
        String[] Symbols = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] Values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Values.length;i++){
            while(num>=Values[i]){
                sb.append(Symbols[i]);
                num -= Values[i];
                
            }
        }
        return sb.toString();
    }
}