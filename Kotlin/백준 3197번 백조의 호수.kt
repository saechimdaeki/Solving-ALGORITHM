import java.util.*
import kotlin.system.exitProcess

private lateinit var crr:Array<Array<Char>>
private val dx= intArrayOf(-1,1,0,0)
private val dy= intArrayOf(0,0,1,-1)
private lateinit var watercheck:Array<Array<Boolean>>
private lateinit var baekzocheck:Array<Array<Boolean>>
private var startx=0
private var starty=0
private var endx=0
private var endy=0
private var baekcheck=false
fun main() {
    val br=System.`in`.bufferedReader()
    val (r,c)=br.readLine().split(" ").map { it.toInt() }
    crr=Array(r){Array(c){' '} }
    watercheck=Array(r){Array(c){false}}
    baekzocheck= Array(r){Array(c){false}}
    var cnt=0
    var baekzo=LinkedList<Pair<Int,Int>>()
    var nextbaekzo=LinkedList<Pair<Int,Int>>()
    var water=LinkedList<Pair<Int,Int>>()
    var nextwater=LinkedList<Pair<Int,Int>>()
    for(i in 0 until r)
    {
        val input=br.readLine()
        for(j in input.indices) {
            crr[i][j] = input[j]
            if(crr[i][j]=='L')
            {
                if(!baekcheck)
                {
                    startx=i
                    starty=j
                    baekcheck=true
                }else
                {
                    endx=i
                    endy=j
                }
                crr[i][j]='.'
            }
            if(crr[i][j]=='.')
            {
                watercheck[i][j]=true
                water.offer(Pair(i,j))
            }
        }
    }
    baekzo.offer(Pair(startx,starty))
    baekzocheck[startx][starty]=true
    while (true)
    {
        while (water.isNotEmpty())
        {
            val (nowwaterx,nowwatery)=water.poll()
            crr[nowwaterx][nowwatery]='.'
            for(i in 0 until 4)
            {
                val nextwaterx=nowwaterx+dx[i]
                val nextwatery=nowwatery+dy[i]
                if(nextwaterx in 0 until r && nextwatery in 0 until c)
                {
                    if(!watercheck[nextwaterx][nextwatery]) {
                        if (crr[nextwaterx][nextwatery] == 'X') {
                            nextwater.add(Pair(nextwaterx, nextwatery))
                            watercheck[nextwaterx][nextwatery] = true
                        } else {
                            water.offer(Pair(nextwaterx, nextwatery))
                            watercheck[nextwaterx][nextwatery] = true
                        }
                    }
                }
            }
        }
        while (baekzo.isNotEmpty())
        {
            val (nowbaekx,nowbaeky)=baekzo.poll()
            for(i in 0 until 4)
            {
                val nextbaekx=nowbaekx+dx[i]
                val nextbaeky=nowbaeky+dy[i]
                if(nextbaekx in 0 until r && nextbaeky in 0 until c)
                {
                    if(!baekzocheck[nextbaekx][nextbaeky])
                    {
                        if(crr[nextbaekx][nextbaeky]=='X')
                        {
                            nextbaekzo.offer(Pair(nextbaekx,nextbaeky))
                            baekzocheck[nextbaekx][nextbaeky]=true
                        }else{
                            baekzo.offer(Pair(nextbaekx,nextbaeky))
                            baekzocheck[nextbaekx][nextbaeky]=true
                        }
                    }
                }
            }
        }
        if(baekzocheck[endx][endy])
        {
            println("$cnt\n")
            exitProcess(0)
        }
        baekzo=nextbaekzo
        water=nextwater
        nextbaekzo=LinkedList()
        nextwater=LinkedList()
        cnt++
    }

}