class Solution {
    /*
    I before V and X
    X before L and C
    
    check find smaller items.
    something goes befrore, deduct.
    
    Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

    starting from back, shifting left, 
        V,X - find the I
        L,C - find X
        D,M - find C
    else-> increment
    
    */
    public int romanToInt(String s) {
        int integer = 0;
        int n = s.length();
        int currIdx =n-1;
        
        while(currIdx>=0){
            char currSymbol = s.charAt(currIdx);
            if(currSymbol == 'I'){
                integer +=1;
            }else if(currSymbol == 'V'){
                if(currIdx>0 && s.charAt(currIdx-1) =='I'){
                    currIdx --;
                    integer+=4;
                }else
                    integer +=5;
            }else if(currSymbol == 'X'){
                if(currIdx>0 && s.charAt(currIdx-1) =='I'){
                    currIdx --;
                    integer+=9;
                }else
                    integer +=10;
            }else if(currSymbol == 'L'){
                if(currIdx>0 && s.charAt(currIdx-1) =='X'){
                    currIdx --;
                    integer+=40;
                }else
                    integer +=50;
            }else if(currSymbol == 'C'){
                if(currIdx>0 && s.charAt(currIdx-1) =='X'){
                    currIdx --;
                    integer+=90;
                }else
                    integer +=100;
            }else if(currSymbol == 'D'){
                if(currIdx>0 && s.charAt(currIdx-1) =='C'){
                    currIdx --;
                    integer+=400;
                }else
                    integer +=500;
            }else if(currSymbol == 'M'){
                if(currIdx>0 && s.charAt(currIdx-1) =='C'){
                    currIdx --;
                    integer+=900;
                }else
                    integer +=1000;
            }
            currIdx--;
        }
        return integer;
    }
}