package 릿코드.DefangingAnIpAddress

class Solution {
    fun defangIPaddr(address: String): String {
        var answer=""
        for(i in address.indices){
            if(address[i]=='.'){
                answer+="["
                answer+=address[i]
                answer+="]"
            }else{
                answer+=address[i]
            }
        }
        return answer
    }
}

fun main() {
    val s=Solution()
    println(s.defangIPaddr("1.1.1.1"))
    println(s.defangIPaddr("255.100.50.0"))
}