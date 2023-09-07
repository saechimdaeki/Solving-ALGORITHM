package 코틀린.LeetCode.Smallest_String_Starting_From_Leaf

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    val map = mutableMapOf<Int,Char>()
    val list = mutableListOf<String>()
    fun smallestFromLeaf(root: TreeNode?): String {
        (0..25).forEach { map[it] = (97 + it).toChar() }
        dfs(root, "")
        val answerList = mutableListOf<String>()
        val answer = StringBuilder()
        for (s1 in list) {
            val split = s1.split(",")
            for (s in split) {
                if (s.isNotBlank())
                    answer.append(map[s.toInt()])
            }
            answerList.add(answer.toString())
            answer.setLength(0)
        }
        return answerList.sorted()[0]
    }

    fun dfs(node: TreeNode? , num : String) {
        if (node == null)
            return

        val sum = node.`val`.toString() + "," + num

        if (node.left == null && node.right == null) {
            list.add(sum)
            return
        }
        dfs(node.left, sum)
        dfs(node.right, sum)
    }
}

