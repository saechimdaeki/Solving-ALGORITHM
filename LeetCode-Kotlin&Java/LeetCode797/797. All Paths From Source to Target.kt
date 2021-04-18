package LeetCode797

class Solution {

    private lateinit var visited:BooleanArray
    val answer= mutableListOf<ArrayList<Int>>()
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        visited= BooleanArray(graph.size)
        dfs(graph,0,ArrayList<Int>())
        return answer
    }
    fun dfs(graph: Array<IntArray>, start:Int, path:ArrayList<Int>){
        if(visited[start]) return
        if(start==graph.size-1){
            val list=ArrayList<Int>(path)
            list.add(start)
            answer.add(list)
            return
        }
        path.add(start)
        visited[start]=true
        for(i in graph[start].indices){
            val list=ArrayList<Int>(path)
            dfs(graph,graph[start][i],list)
        }
        visited[start]=false
    }
}
/* discussion 풀이
class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(0);
        dfs(ans,res,graph.length - 1 , 0 , graph);
        return ans;
    }

    private void dfs(List<List<Integer>>ans,List<Integer>res ,int target ,int source ,int[][]graph){
        if(target == source){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int nei : graph[source]){
            res.add(nei);
            dfs(ans,res,target,nei,graph);
            res.remove(res.size() - 1);
        }

    }
}
 */