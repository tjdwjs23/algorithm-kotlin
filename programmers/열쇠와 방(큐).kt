/**
* 에서 n로 표시된 방이 있으며  방을 제외한 모든 방은 잠겨 있습니다 . 당신의 목표는 모든 방을 방문하는 것입니다. 그러나 열쇠가 없으면 잠긴 방에 들어갈 수 없습니다.0n - 10

* 방을 방문하면 그 방에서 고유한 열쇠 세트를 찾을 수 있습니다 . 각 열쇠에는 어느 방의 잠금이 해제되는지 나타내는 숫자가 있으며, 이 열쇠를 모두 가져가면 다른 방의 잠금을 해제할 수 있습니다.

* room을 방문했을 때 얻을 수 있는 키 세트가 있는 rooms배열 이 주어지면 모든 방을 방문할 수 있으면 반환하고 그렇지 않으면 반환합니다 .rooms[i]itrue false
*/

class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val n = rooms.size
        val visited = BooleanArray(n) { false }
        val queue = java.util.ArrayDeque<Int>()
        queue.add(0)

        while (queue.isNotEmpty()) {
             // 현재 방문하는 방
            val currentRoom = queue.removeFirst()
            if (!visited[currentRoom]) {
                visited[currentRoom] = true
                for (key in rooms[currentRoom]) {
                    if (!visited[key]) {
                        // 방문하지않았다면 큐에 추가
                        queue.add(key)
                    }
                }
            }
        }
        // 모든 방을 방문했는지 확인
        return visited.all { it }

    }
}
