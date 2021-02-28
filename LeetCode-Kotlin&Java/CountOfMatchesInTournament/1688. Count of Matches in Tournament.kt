package CountOfMatchesInTournament

class Solution {
    fun numberOfMatches(n: Int): Int {
        var number=n
        var answer=0
        while (number !=1){
            val tmp=number/2
            answer+=tmp
            number=(number-tmp)
        }
        return answer
    }
}

