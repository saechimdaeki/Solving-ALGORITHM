package LeetCode1079

class Solution {
    private lateinit var visited:BooleanArray
    private val list= arrayListOf<String>()
    fun numTilePossibilities(tiles: String): Int {
        visited= BooleanArray(tiles.length)
        dfs(tiles,StringBuffer())
        return list.distinct().size
    }
    fun dfs(tiles: String,string:StringBuffer){
        tiles.indices.forEach { i ->
            if(!visited[i]){
                string.append(tiles[i])
                visited[i]=true
                list.add(string.toString())
                dfs(tiles,string)
                string.setLength(string.length-1)
                visited[i]=false
            }
        }
    }
}