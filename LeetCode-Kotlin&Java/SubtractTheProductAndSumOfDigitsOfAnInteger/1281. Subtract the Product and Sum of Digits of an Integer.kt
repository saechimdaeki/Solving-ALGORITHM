package SubtractTheProductAndSumOfDigitsOfAnInteger

class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var sum=0
        var mul=1
        var temp=n
        while (temp>0){
            mul*=temp%10
            sum+=temp%10
            temp/=10
        }
        return mul-sum
    }
}