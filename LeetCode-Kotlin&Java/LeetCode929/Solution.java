package LeetCode929;

import java.util.HashSet;

import java.util.Set;

/* 929. Unique Email Addresses*/
public class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set=new HashSet<>();
        for (String email : emails) {
            if(!email.contains(".") ||!email.contains("@"))
                continue;
            String[] split = email.split("@");
            String id=split[0];
            StringBuilder sb=new StringBuilder();
            for (char c : id.toCharArray()) {
                if(c=='.') continue;
                if(c=='+') break;
                sb.append(c);
            }
            sb.append('@');
            String domain=split[1];
            sb.append(domain);
            set.add(sb.toString());
        }
        return set.size();
    }
}

