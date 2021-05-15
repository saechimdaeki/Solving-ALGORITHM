package LeetCode1381;

import java.util.ArrayList;
import java.util.List;

/* 1381. Design a Stack With Increment Operation */
class CustomStack {
    private int max;
    private List<Integer> list=new ArrayList<>();
    public CustomStack(int maxSize) {
        this.max=maxSize;
    }

    public void push(int x) {
        if(list.size()<max)
            list.add(x);
    }

    public int pop() {
        if(list.isEmpty()) return -1;
        return list.remove(list.size()-1);
    }

    public void increment(int k, int val) {
       for(int i=0; i<Math.min(k,list.size()); i++)
            list.set(i,val+list.get(i));
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
