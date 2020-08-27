package 백준

fun main() {
    val br=System.`in`.bufferedReader()
    val bw=System.out.bufferedWriter()
    val t=br.readLine().toInt()
    repeat(t){
        val n=br.readLine().toInt()
        var answer=0
        for(i1 in 1 .. 3){
            if(i1==n)
                answer++
            for(i2 in 1..3){
                if(i1+i2==n)
                    answer++
                for(i3 in 1..3){
                    if(i1+i2+i3==n)
                        answer++
                    for(i4 in 1..3){
                        if (i1+i2+i3+i4==n)
                            answer++
                        for(i5 in 1..3){
                            if(i1+i2+i3+i4+i5==n)
                                answer++
                            for(i6 in 1..3){
                                if(i1+i2+i3+i4+i5+i6==n){
                                    answer++
                                }
                                for(i7 in 1..3){
                                    if(i1+i2+i3+i4+i5+i6+i7==n)
                                        answer++
                                    for(i8 in 1..3){
                                        if(i1+i2+i3+i4+i5+i6+i7+i8==n)
                                            answer++
                                        for(i9 in 1..3){
                                            if(i1+i2+i3+i4+i5+i6+i7+i8+i9==n)
                                                answer++
                                            for(i10 in 1..3){
                                                if(i1+i2+i3+i4+i5+i6+i7+i8+i9+i10==n)
                                                    answer++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        bw.write("$answer\n")
    }
    bw.flush()
}