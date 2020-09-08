package 프로그래머스.베스트앨범

class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val map= mutableMapOf<String,Int>()
        val list= arrayListOf<Triple<String,Int,Int>>()//장르,play,index
        for(i in genres.indices){
          list.add(Triple(genres[i],plays[i],i))
            if(map.containsKey(genres[i]))
                map[genres[i]] = map[genres[i]]!!+plays[i]
            else
                map[genres[i]]=plays[i]
        }
        val firstComparator= compareBy<Triple<String,Int,Int>>{ -map[it.first]!! }
        val secondComparator=firstComparator.thenBy { -it.second }
        val thirdComparator=secondComparator.thenBy { it.third }
        list.sortWith(thirdComparator)
        val record= mutableMapOf<String,Int>()
        val album= arrayListOf<Int>()
        for(i in list) {
            if (record.containsKey(i.first)) {
                if(record[i.first]!!>=2) continue
                record[i.first] = record[i.first]!!+1
                album.add(i.third)
            } else {
                    record[i.first] =1
                    album.add(i.third)
            }
        }
        return album.toIntArray()
    }
}

fun main() {
    val s=Solution()
    val answer=s.solution(arrayOf("classic","pop","classic","classic","pop"), intArrayOf(500,600,150,800,2500))
    for(i in answer)
        print("$i ")
}