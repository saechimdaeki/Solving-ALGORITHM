package _3진법뒤집기;

import java.math.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder s=new StringBuilder();
        while(n!=0){
            if(n<3){
                s.append(n);
                n=0;
            }else if(n%3==0){
                s.append(0);
                n/=3;
            }else{
                s.append(n%3);
                n/=3;
            }
        }
        String temp=s.toString();
        for(int i=0; i<temp.length(); i++){
            answer+=(Math.pow(3,temp.length()-1-i)*(temp.charAt(i)-'0'));
        }
        return answer;
    }
}
// class _3진법뒤집기.Solution {
//     public int solution(int n) {
//         String s="";
//         while(n!=0){
//             s=(n%3)+s;
//             n/=3;
//         }
//         s = new StringBuilder(s).reverse().toString();
//     return Integer.parseInt(s,3);
//     }

// }