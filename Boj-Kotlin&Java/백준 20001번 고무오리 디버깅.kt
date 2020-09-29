package 백준

fun main() {
    val br=System.`in`.bufferedReader(charset = Charsets.UTF_8)
    val bw=System.out.bufferedWriter(charset=Charsets.UTF_8)
    var problem=0
    loop@ while (true){
        when (br.readLine().toString()) {
            "고무오리 디버깅 시작" -> {
                continue@loop
            }
            "문제" -> {
                problem++
            }
            "고무오리" -> {
                if(problem==0)
                    problem+=2
                else{
                    problem--
                }
            }
            else -> {
                break@loop
            }
        }
    }
    when (problem) {
        0 -> bw.write("고무오리야 사랑해")
        else -> bw.write("힝구")
    }
    bw.flush()
}
/* 똑같은로직 cpp는 정답이뜸.
#include<iostream>
using namespace std;

int main(){
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    string input;
    int problem=0;
    while(1){
        getline(cin,input);
        if(input=="고무오리 디버깅 시작")
            continue;
        else if(input=="문제")
            problem++;
        else if(input=="고무오리"){
            if(problem>0) problem--;
            else problem+=2;
        }else{
            break;
        }
    }
    if(problem==0)
        cout<<"고무오리야 사랑해";
    else
    cout<<"힝구";
}

 */