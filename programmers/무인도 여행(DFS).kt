/**
 * 문제 설명
 * 메리는 여름을 맞아 무인도로 여행을 가기 위해 지도를 보고 있습니다. 지도에는 바다와 무인도들에 대한 정보가 표시돼 있습니다. 지도는 1 x 1크기의 사각형들로 이루어진 직사각형 격자 형태이며, 격자의 각 칸에는 'X' 또는 1에서 9 사이의 자연수가 적혀있습니다. 지도의 'X'는 바다를 나타내며, 숫자는 무인도를 나타냅니다. 이때, 상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룹니다. 지도의 각 칸에 적힌 숫자는 식량을 나타내는데, 상, 하, 좌, 우로 연결되는 칸에 적힌 숫자를 모두 합한 값은 해당 무인도에서 최대 며칠동안 머물 수 있는지를 나타냅니다. 어떤 섬으로 놀러 갈지 못 정한 메리는 우선 각 섬에서 최대 며칠씩 머물 수 있는지 알아본 후 놀러갈 섬을 결정하려 합니다.
 *
 * 지도를 나타내는 문자열 배열 maps가 매개변수로 주어질 때, 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return 하는 solution 함수를 완성해주세요. 만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return 해주세요.
 */

class Solution {
    fun solution(maps: Array<String>): IntArray {
        // 이동할 수 있는 4가지 방향을 정의합니다. (상, 하, 좌, 우)
        val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

        // 지도의 크기를 저장합니다.
        val n = maps.size
        val m = maps[0].length

        // 방문 여부를 저장할 visited 배열을 생성합니다.
        val visited = Array(n) { BooleanArray(m) }

        // 각 섬의 최대 체류 가능 일수를 저장할 리스트
        val result = mutableListOf<Int>()

        // 지도의 모든 칸을 탐색합니다.
        for (i in maps.indices) {
            for (j in maps[0].indices) {
                // 현재 칸이 섬이고 아직 방문하지 않았다면
                if (maps[i][j] != 'X' && !visited[i][j]) {
                    // DFS를 통해 현재 섬의 최대 체류 가능 일수를 계산합니다.
                    result.add(dfs(maps, visited, i, j, directions))
                }
            }
        }

        // 만약 지낼 수 있는 무인도가 없다면 -1을 반환합니다.
        return if (result.isEmpty()) intArrayOf(-1) else result.sorted().toIntArray()
    }

    private fun dfs(
        maps: Array<String>,
        visited: Array<BooleanArray>,
        x: Int,
        y: Int,
        directions: Array<Pair<Int, Int>>
    ): Int {
        // 현재 칸을 방문 처리합니다.
        visited[x][y] = true

        // 현재 칸의 식량 값을 저장합니다.
        var totalFood = maps[x][y].digitToInt()

        // 상, 하, 좌, 우로 이동하며 DFS를 수행합니다.
        for ((dx, dy) in directions) {
            val newX = x + dx
            val newY = y + dy

            // 새로운 칸이 지도 범위 내에 있고, 섬이며, 아직 방문하지 않았다면
            if (newX in maps.indices && newY in maps[0].indices && maps[newX][newY] != 'X' && !visited[newX][newY]) {
                // DFS를 수행하여 해당 섬의 최대 체류 가능 일수를 계산하고, 총 식량에 더합니다.
                totalFood += dfs(maps, visited, newX, newY, directions)
            }
        }

        return totalFood
    }
}