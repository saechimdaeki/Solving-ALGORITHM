package LeetCode784;

import java.util.ArrayList;
import java.util.List;

/* 784. Letter Case Permutation */
class Solution {
    ArrayList<String> list;
    public List<String> letterCasePermutation(String S) {
        list=new ArrayList<>();
        dfs(S.toCharArray(),0);
        return list;
    }
    private void dfs(char[] arr,int choice){
        list.add(new String(arr));
        for(int i=choice; i<arr.length; i++){
            char temp=arr[i];
            if(Character.isLetter(temp)){
                if(Character.isUpperCase(temp)){
                    arr[i] =Character.toLowerCase(temp);
                }else{
                    arr[i]=Character.toUpperCase(temp);
                }
                dfs(arr,i+1);
                arr[i]=temp;
            }
        }
    }
}
