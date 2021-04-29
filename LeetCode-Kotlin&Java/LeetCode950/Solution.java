package LeetCode950;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> q=new LinkedList<>();
        int[] arr=new int[deck.length];
        Arrays.sort(deck);
        IntStream.range(0, deck.length).forEachOrdered(q::offer);
        int idx=0;
        while (!q.isEmpty()){
            arr[q.poll()]=deck[idx];
            if(!q.isEmpty()){
                q.offer(q.poll());
            }
            idx++;
        }
        return arr;
    }
}
