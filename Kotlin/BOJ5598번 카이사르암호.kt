package boj14681kot

import java.io.BufferedReader
import java.io.InputStreamReader


fun main(args: Array<String>)
{
    val br=BufferedReader(InputStreamReader(System.`in`))
    var s=br.readLine()
    var map= mutableMapOf<Char,Char>()
    for(a in 'A' until 'Z')
    {
        when (a) {
            'A' -> map.put(a,'X')
            'B' -> map.put(a,'Y')
            'C' -> map.put(a,'Z')
            else -> map.put(a,a-3)
        }
    }
    map.put('Z','W')
    for (i in s.indices)
    {
        print(map.get(s[i]))
    }
}