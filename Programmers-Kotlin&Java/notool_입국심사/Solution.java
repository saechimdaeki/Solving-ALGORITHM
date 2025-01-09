package programmers.notool_입국심사;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long left=0,right=0;
		for (int time : times)
			if (right < time)
				right = time;
        
        right *=n;
        
        while(left<=right) {
            long fin = 0;
            long mid = (left+right)/2;
			for (int time : times)
				fin += mid / time;
            if (fin < n) left = mid +1;
            else right = mid -1;
            
        }
        
        return left;
    }
}