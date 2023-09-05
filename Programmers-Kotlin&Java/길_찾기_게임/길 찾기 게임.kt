package 코틀린.programmers.길_찾기_게임


class Solution {
    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val answer = mutableListOf<IntArray>()
        val list = mutableListOf<Node>()
        for(i in nodeinfo.indices) {
            list.add(Node().apply {
                num = i + 1
                x = nodeinfo[i][0]
                y = nodeinfo[i][1]
            })
        }
        val sortedWith = list.sortedWith(compareByDescending<Node> { it.y }.thenBy { it.x })

        val rootNode = sortedWith[0]
        (1 until sortedWith.size)
            .asSequence()
            .map { sortedWith[it] }
            .forEach { insert(rootNode, it) }

        val postList = mutableListOf<Int>()
        val preList = mutableListOf<Int>()

        preOrder(rootNode, preList)
        postOrder(rootNode, postList)

        answer.add(preList.toIntArray())
        answer.add(postList.toIntArray())
        return answer.toTypedArray()
    }
}

fun insert(rootNode: Node, childNode: Node) {
    when {
        rootNode.x > childNode.x -> {
            rootNode.left?.let {
                insert(it, childNode)
            } ?: run {
                rootNode.left = childNode
            }
        }
        else -> {
            rootNode.right?.let {
                insert(it, childNode)
            } ?: run {
                rootNode.right = childNode
            }
        }
    }
}

fun postOrder(node: Node?, answer: MutableList<Int>) {
    if (node != null) {
        postOrder(node.left, answer)
        postOrder(node.right, answer)
        answer.add(node.num)
    }
}

fun preOrder(node: Node?, answer: MutableList<Int>) {
    if (node != null) {
        answer.add(node.num)
        preOrder(node.left, answer)
        preOrder(node.right, answer)
    }
}


class Node {
    var num = 0
    var x = 0
    var y = 0
    var left: Node? = null
    var right: Node? = null
}


fun main() {
    Solution().apply {
        val solution = solution(
            arrayOf(
                intArrayOf(5, 3), intArrayOf(11, 5), intArrayOf(13, 3), intArrayOf(3, 5), intArrayOf(6, 1),
                intArrayOf(1, 3), intArrayOf(8, 6), intArrayOf(7, 2), intArrayOf(2, 2)
            )
        )

        println(solution.contentDeepToString()) // [7,4,6,9,1,8,5,2,3],[9,6,5,8,1,4,3,2,7]
    }
}