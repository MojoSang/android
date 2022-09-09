package com.example.utils;

public class tools {
    //xaybz
    //判断结果
    public static int check(int x,int y,int z,char a,char b){
        int result=-1;
        if (a == '+') {
            if(b=='+')
                result=x+y+z;
            else if(b=='-')
                result= x+y-z;
            else if(b=='*')
                result =x+y*z;
            else if(b=='/'){
                if(z==0) result= -1;
                else if(y%z!=0) result= -1;
                else result= x+y/z;
            }
        }
        else if(a=='-'){
            if(b=='+')
                result= x-y+z;
            else if(b=='-')
                result =x-y-z;
            else if(b=='*')
                result =x-y*z;
            else if(b=='/'){
                if(z==0) result= -1;
                else if(y%z!=0) result= -1;
                else result= x-y/z;
            }
        }
        else if(a=='*'){
            if(b=='+')
                result= x*y+z;
            else if(b=='-')
                result= x*y-z;
            else if(b=='*')
                result= x*y*z;
            else if(b=='/'){
                if(z==0) result= -1;
                else if(y%z!=0) result= -1;
                else result= x*y/z;
            }
            else if(a=='/') {
                if(y==0) result= -1;
                else if(x%y!=0) result= -1;
                else {
                    if (b == '+')
                        result= x / y + z;
                    else if (b == '-')
                        result= x / y - z;
                    else if (b == '*')
                        result= x / y * z;
                    else if (b == '/') {
                        if (z == 0) result= -1;
                        else if(y%z!=0) result= -1;
                        else result= x / y / z;
                    }
                }
            }
        }
        if(result>100 || result<0) result=-1;
        return result;
    }

}
