package UniqueMorseCodeWords

class Solution {
    fun uniqueMorseRepresentations(words: Array<String>): Int {
        val charr= arrayOf(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--..")
        val set=HashSet<String>()
        for (word in words) {
            val s=StringBuilder()
            for (c in word) {
                s.append(charr[(c-97).toInt()])
            }
            set.add(s.toString())
        }
        return set.size
    }
}
// faster than 100.00% of Kotlin online submissions for Unique Morse Code Words. saechimdaeki