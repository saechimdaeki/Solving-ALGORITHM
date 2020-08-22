package boj14681kot

private lateinit var charr:Array<Char>
fun main(args:Array<String>)
{
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val k=br.readLine().toInt()
    charr=Array(k){' '}
    val input=br.readLine().split(" ")
    for(i in 0 until k)
        charr[i]=input[i][0]
    val small=Array(k+1){0}
    val big=Array(k+1){0}
    for(i in 0..k)
    {
        small[i]=i
        big[i]=9-i
    }
    do{
        if(check(charr, small))
            break
    }while(next(small))

    do{
        if(check(charr,big))
            break
    }while (previous(big))
    for(i in big.indices)
        print("${big[i]}")
    println()
    for(i in small.indices)
        print("${small[i]}")
    println()

}

private fun next(a:Array<Int>):Boolean
{
    var i =a.size-1
    while (i>0 && a[i-1]>=a[i])
        i--
    if(i<=0)
        return false
    var j =a.size-1
    while(a[j]<=a[i-1])
        j--
    var tmp=a[i-1]
    a[i-1]=a[j]
    a[j]=tmp
    j=a.size-1
    while(i<j)
    {
        tmp=a[i]
        a[i]=a[j]
        a[j]=tmp
        i++
        j--
    }
    return true
}
private fun previous(a:Array<Int>):Boolean{
    var i =a.size-1
    while (i>0 && a[i-1]<=a[i])
        i--
    if(i<=0)
        return false
    var j =a.size-1
    while(a[j]>=a[i-1])
        j--
    var tmp=a[i-1]
    a[i-1]=a[j]
    a[j]=tmp
    j=a.size-1
    while(i<j)
    {
        tmp=a[i]
        a[i]=a[j]
        a[j]=tmp
        i++
        j--
    }
    return true
}
private fun check(a:Array<Char>,b:Array<Int>):Boolean{
    for(i in a.indices)
    {
        if(a[i]=='<' && b[i]>b[i+1])
            return false
        if(a[i]=='>' && b[i]<b[i+1])
            return false
    }
    return true
}