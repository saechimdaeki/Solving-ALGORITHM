package 구름

import java.util.Scanner
fun main(args: Array<String>) {
    val input = readLine()!!
    var left=0
    var right=input.length-1
    var answer=""
    while (left<right){
        answer+=input[left++]
        answer+=input[right--]
    }
    if(input.length%2!=0)
        answer+=input[input.length/2]
    println(answer)
}