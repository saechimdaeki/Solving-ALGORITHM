package CountItmesMatchingaRule

class Solution {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {
        val list= arrayListOf<Triple<String,String,String>>()

        for (item in items) {
            list.add(Triple(item[0],item[1],item[2]))
        }
        var answer=0
        when (ruleKey) {
            "type" -> {
                for (triple in list) {
                    if(triple.first == ruleValue)
                        answer++
                }
            }
            "color" -> {
                for (triple in list) {
                    if(triple.second==ruleValue)
                        answer++
                }

            }
            "name" -> {
                for (triple in list) {
                    if(triple.third==ruleValue)
                        answer++
                }
            }
        }
        return answer
    }
}