/**
 * 지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다. 산책은 로봇 강아지에 미리 입력된 명령에 따라 진행하며, 명령은 다음과 같은 형식으로 주어집니다.
 * 
 * ["방향 거리", "방향 거리" … ]
 * 예를 들어 "E 5"는 로봇 강아지가 현재 위치에서 동쪽으로 5칸 이동했다는 의미입니다. 로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
 * 
 * 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
 * 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
 * 위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
 * 공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.
 * 공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때, 로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 */

class Solution {
    private fun findStart(park: Array<String>): MutableList<Int> {
        for (i in park.indices)
            for (j in park[i].indices)
                if (park[i][j] == 'S')
                    return mutableListOf(i, j)
        return mutableListOf(0, 0)
    }

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        val directions = mapOf('E' to (0 to 1), 'W' to (0 to -1), 'N' to (-1 to 0), 'S' to (1 to 0))
        return routes.map { it[0] to it.drop(2).toInt() }
                .fold(findStart(park)) { pos, (direction, distance) ->
                    val prevPos = pos.toMutableList()
                    val nextPos = pos.toMutableList()
                    repeat(distance) {
                        nextPos[0] += directions[direction]!!.first
                        nextPos[1] += directions[direction]!!.second
                        if (!(0 <= nextPos[0] && nextPos[0] < park.size && 0 <= nextPos[1] && nextPos[1] < park[0].length && park[nextPos[0]][nextPos[1]] != 'X')) 
                            return@fold prevPos
                    }
                    return@fold nextPos
                }.toIntArray()
    }
}
