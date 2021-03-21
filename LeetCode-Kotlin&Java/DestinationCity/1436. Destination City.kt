package DestinationCity

class Solution {
    fun destCity(paths: List<List<String>>): String {
        val entry=HashSet<String>()
        for (path in paths) {
            entry.add(path[0])
        }
        for (path in paths) {
            val to=path[1]
            if(!entry.contains(to))
                return to
        }
        return ""
    }
}
