package LeetCode2103;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * LeetCode 2103. Rings and Rods
 * // input: B0R0G0R9R0B0G0 output: 1
 * // input: G4 output: 0
 */
class Solution {
    public int countPoints(String rings) {
        Map<Character, String> map = new HashMap<>();
        IntStream.iterate(0, i -> i < rings.length(), i -> i + 2)
                 .forEachOrdered(i -> {
                     char c1 = rings.charAt(i);
                     char c2 = rings.charAt(i + 1);
                     map.compute(c2, (character, string) -> map.get(c2) + c1);
                     map.computeIfAbsent(c2, character -> Character.toString(c1));
                 });
        AtomicInteger cnt = new AtomicInteger(0);
        Predicate<String> predicate = (string) -> string.contains("R") && string.contains("G") && string.contains("B");
        map.forEach((k, v) -> {
            if (predicate.test(v)) {
                cnt.getAndIncrement();
            }
        });
        return cnt.get();
    }

}

//    public static void main(String[] args) {
//        System.out.println(        countPoints("B0R0G0R9R0B0G0"));
//        System.out.println(        countPoints("G4"));
//    }
