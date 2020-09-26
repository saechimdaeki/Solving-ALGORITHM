package 프로그래머스.방금그곡;

/* `(None)` 이아닌 (None) 이란걸 제대로 잘읽자...... */
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max=-1234;
        m=m.replaceAll("A#","a").replaceAll("C#","c")
                .replaceAll("D#","d").replaceAll("F#","f")
                .replaceAll("G#","g");
        for(int i=0; i< musicinfos.length; i++){
            musicinfos[i]=musicinfos[i].replaceAll("A#","a").replaceAll("C#","c")
                    .replaceAll("D#","d").replaceAll("F#","f")
                    .replaceAll("G#","g");
           // System.out.println(m);

            String[] temp=musicinfos[i].split(",");
            String Title=temp[2],Lyrics=temp[3];
            StringBuilder tmp= new StringBuilder();
            String[] tp=temp[0].split(":");
            String[] tp2=temp[1].split(":");
            int playtime=Integer.parseInt(tp2[0])*60+Integer.parseInt(tp2[1])-(Integer.parseInt(tp[0]) *60 +Integer.parseInt(tp[1]));
            //System.out.println(playtime);
            int cnt=0;
            for(int j=0; j<playtime; j++){
                tmp.append(Lyrics.charAt(cnt++));
                if(cnt>=Lyrics.length()) cnt=0;
            }
            if(tmp.toString().contains(m)) {
                if(max<playtime) {
                    answer = Title;
                    max=playtime;
                }
            }
        }
        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.solution("ABCDEFG",new String[]{"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(s.solution("CC#BCC#BCC#BCC#B",new String[]{"03:00,03:30,FOO,CC#B","04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(s.solution("ABC",new String[]{"12:00,12:14,HELLO,C#DEFGAB","13:00,13:05,WORLD,ABCDEF"}));
    }
}
