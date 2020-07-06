package boj14681kot

import kotlin.system.exitProcess

fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val s=br.readLine()
    var tmp=""
    val list=ArrayList<String>()
    val answer=ArrayList<String>()
    for(i in s.indices)
    {
        if(i==s.length-1)
        {
            if(s[i]!='.') {
                tmp += s[i]
                list.add(tmp)
            }else
            {
                list.add(tmp)
                list.add(".")
            }
        }
        else if(s[i]=='.')
        {
            if(tmp!="") {
                list.add("$tmp")
                list.add(".")
            }
            else
            list.add(".")
            tmp=""
        }else{
            tmp+=s[i]
        }
    }

    for(i in list)
    {
        var xcount=0
        var tmp=""
        if(i==".") {
            answer.add(".")
        }
        else {
            for (j in i.indices) {
                if (i[j] == 'X')
                    xcount++
            }
            var divcount=xcount/4
            var bcount=xcount%4
            for(j in 0 until divcount)
                tmp+="AAAA"
            if(bcount%2!=0)
            {
                println(-1)
                exitProcess(0)
            }else{
                for(j in 0 until bcount/2)
                    tmp+="BB"
            }
            answer.add(tmp)
        }
    }
    for(i in answer)
        print("$i")
}