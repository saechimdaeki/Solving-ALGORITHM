package DetermineIfStringHalvesAreAlike

class Solution {
    fun halvesAreAlike(s: String): Boolean {
        val (a,b)= arrayOf(s.substring(0,s.length/2).toLowerCase(),s.substring(s.length/2).toLowerCase())
        var (cnt1,cnt2)= arrayOf(0,0)
        for (c in a) {
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                cnt1++
        }
        for(c in b){
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')
                cnt2++
        }
        return cnt1==cnt2
    }
}