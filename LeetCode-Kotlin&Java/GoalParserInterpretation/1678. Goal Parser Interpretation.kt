package GoalParserInterpretation

class Solution {
    fun interpret(command: String): String {
        val answer=StringBuilder()
        loop@ command.indices.forEach { i ->
            when {
                command[i]=='(' -> {
                    if(command[i+1]==')')
                        answer.append("o")
                }
                command[i]==')' -> {
                    return@forEach
                }
                else -> {
                    answer.append(command[i])
                }
            }
        }
        return answer.toString()
    }
}