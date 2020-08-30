package 백준
private lateinit var arr:Array<Array<Int>>
fun main() {
    val br=System.`in`.bufferedReader()
    val n=br.readLine().toInt()
    arr=Array(n){Array(n){0}}
    for(i in 0 until n){
        val input=br.readLine().split(" ").map { it.toInt() }
        for(j in input.indices)
            arr[i][j]=input[j]
    }
    println("${dfs(0,1,0,n)}")
}
private fun dfs(x: Int, y: Int, di: Int, n:Int): Int {
    if (x == n - 1 && y == n - 1)
        return 1
    var ans = 0
    if (di == 0) { // -
        if (y + 1 < n && arr[x][y + 1] == 0) {
            ans += dfs(x, y + 1, 0,n)
        }
        if (x + 1 < n && y + 1 < n && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            ans += dfs(x + 1, y + 1, 2,n)
        }
    }else if (di == 1) { // |
        if (x + 1 < n && arr[x + 1][y] == 0) {
            ans += dfs(x + 1, y, 1,n)
        }
        if (x + 1 < n && y + 1 < n && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            ans += dfs(x + 1, y + 1, 2,n)
        }
    }
    else if (di == 2) { // \
        if (y + 1 < n && arr[x][y + 1] == 0) {
            ans += dfs(x, y + 1, 0,n)
        }
        if (x + 1 < n && arr[x + 1][y] == 0) {
            ans += dfs(x + 1, y, 1,n)
        }
        if (x + 1 < n && y + 1 < n && arr[x][y + 1] == 0 && arr[x + 1][y] == 0 && arr[x + 1][y + 1] == 0) {
            ans += dfs(x + 1, y + 1, 2,n)
        }
    }
    return ans
}