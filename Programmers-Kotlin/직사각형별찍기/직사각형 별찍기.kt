package 프로그래머스.직사각형별찍기


fun main(args: Array<String>) {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    for(i in 0 until b){
        for(j in 0 until a){
            print("*")
        }
        println()
    }
}