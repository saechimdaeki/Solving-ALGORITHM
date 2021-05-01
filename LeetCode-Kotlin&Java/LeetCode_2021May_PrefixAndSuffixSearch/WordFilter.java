package LeetCode_2021May_PrefixAndSuffixSearch;

import java.util.ArrayList;
import java.util.HashMap;

class WordFilter {
    static HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        map=new HashMap<>();
        int idx=0;
        for (String word : words) {
            ArrayList<String> plist = new ArrayList<>();
            ArrayList<String> slist = new ArrayList<>();
            for (int j = 0; j < word.length(); j++) {
                plist.add(word.substring(0, word.length() - j));
                slist.add(word.substring(word.length() - j));
            }
            slist.add(word);
            for (String s : plist)
                for (String value : slist)
                    map.put(s + " " + value, idx);
            idx++;
        }

    }

    public int f(String prefix, String suffix) {
        return map.getOrDefault(prefix+" "+suffix,-1);
    }
}
