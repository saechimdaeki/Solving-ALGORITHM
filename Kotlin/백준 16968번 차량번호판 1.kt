

private var s=""
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    s=br.readLine()
    //c : 문자(26)  d:숫자(10) 같은 숫자,문자 두개 연속 불가
    println(bruteForce(0,' '))
}
private fun bruteForce(index:Int,last:Char):Int{
    if(s.length==index)
        return 1;
    var start = if(s[index]=='c')
        'a'
    else
        '0'
    var end=if(s[index]=='c')
        'z'
    else
        '9'
    var answer=0
    for(i in start..end)
    {
        if(i !=last)
            answer+=bruteForce(index+1,i);
    }
    return answer
}