package 백준

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val arr = arrayListOf<Int>()
    repeat(2){
        val input1 = br.readLine().split(" ").map { it.toInt() }
        for(j in input1.indices)
            arr.add(input1[j])
    }

    val answerList= arrayListOf<Pair<Int,Double>>()
    answerList.add(Pair(0,(arr[0].toDouble()/arr[2].toDouble() +arr[1].toDouble()/arr[3].toDouble())))
    answerList.add(Pair(1,(arr[2].toDouble()/arr[3].toDouble() + arr[0].toDouble()/arr[1].toDouble())))
    answerList.add(Pair(2,(arr[3].toDouble()/arr[1].toDouble() + arr[2].toDouble()/arr[0].toDouble())))
    answerList.add(Pair(3,(arr[1].toDouble()/arr[0].toDouble() + arr[3].toDouble()/arr[2].toDouble())))

    val firstcomparator= compareBy<Pair<Int,Double>>{-it.second}
    val secondcomp=firstcomparator.thenBy { it.first }
    answerList.sortWith(secondcomp)
    println(answerList[0].first)
}