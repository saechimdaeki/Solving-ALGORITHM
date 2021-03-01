package MatrixDiagonalSum

class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        val visited=Array(mat.size){BooleanArray(mat[0].size)}
        var ans=0
        mat.indices.forEach { i ->
            mat[i].indices.forEach { j ->
                when (i) {
                    j -> {
                        visited[i][j]=true
                        ans+=mat[i][j]
                    }
                }
            }
        }
        var cnt=0
        repeat (mat.size){
            when {
                !visited[cnt][mat.size-cnt-1] -> ans+=mat[cnt][mat.size-cnt-1]
            }
            cnt++
        }
        return ans
    }
}