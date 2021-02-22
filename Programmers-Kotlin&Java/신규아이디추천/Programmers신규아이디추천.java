public class Programmers신규아이디추천 {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(s.solution("z-+.^."));
        System.out.println(s.solution("=.="));
        System.out.println(s.solution("123_.def"));
        System.out.println(s.solution("abcdefghijklmn.p"));
    }
}

class Solution {
    public String solution(String new_id) {
        //1
        new_id=new_id.toLowerCase();
        StringBuilder newid= new StringBuilder();
        //2
        for(int i=0; i<new_id.length(); i++) {
            if (new_id.charAt(i) >= 'a' && new_id.charAt(i) <= 'z' || new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) >= '0' && new_id.charAt(i) <= '9' || new_id.charAt(i) == '.')
                newid.append(new_id.charAt(i));
            else continue;
        }
        //3
        new_id=newid.toString().replaceAll("[.]{2,}",".");

        //4
        if(new_id.startsWith("."))
           new_id= new_id.substring(1);
        if(new_id.endsWith("."))
            new_id=new_id.substring(0,new_id.length()-1);

        //5
        if(new_id.equals(""))
            new_id+="a";

        //6
        if(new_id.length()>=16)
            new_id=new_id.substring(0,15);
        if(new_id.endsWith("."))
            new_id=new_id.substring(0,new_id.length()-1);

        //7
        if(new_id.length()<=2){
            char tmp=new_id.charAt(new_id.length()-1);
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while (new_idBuilder.length()<3){
                new_idBuilder.append(tmp);
            }
            new_id = new_idBuilder.toString();
        }

        return new_id;
    }
}