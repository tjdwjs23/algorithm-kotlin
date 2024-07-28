/**
 * N×M크기의 배열로 표현되는 미로가 있다.
 * 1	0	1	1	1	1
 * 1	0	1	0	1	0
 * 1	0	1	0	1	1
 * 1	1	1	0	1	1
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때,
 * (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 */

fun main() = System.`in`.bufferedReader().run {
    // 첫 번째 줄에서 R(행의 수)과 C(열의 수)를 읽어들입니다.
    val (R, C) = readLine().split(" ").map { it.toInt() }
    // 미로를 2차원 List로 읽어들입니다. 각 칸은 문자열에서 정수로 변환됩니다.
    val maze = List(R) { readLine().map { it.toString().toInt() } }

    // 방문 여부 및 거리를 저장할 2차원 List를 초기화합니다. 모든 값은 0으로 시작합니다.
    val visit = List(R) { MutableList(C) { 0 } }
    // 이동할 수 있는 4가지 방향을 정의합니다. (우, 하, 좌, 상)
    val directions = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
    // BFS를 위한 큐를 초기화하고, 시작점인 (0, 0)을 추가합니다.
    val queue = ArrayDeque<Pair<Int, Int>>().apply { add(Pair(0, 0)) }
    // 시작점을 방문했다고 표시하고, 시작점의 거리 값을 1로 설정합니다.
    visit[0][0] = 1

    while (queue.isNotEmpty()) {
        // 현재 위치를 큐에서 꺼냅니다.
        val (curR, curC) = queue.removeFirst()

        // 정의된 4가지 방향에 대해 반복합니다.
        for ((dr, dc) in directions) {
            val newR = curR + dr
            val newC = curC + dc
            // 새로운 위치가 미로 내부에 있고, 아직 방문하지 않았으며, 이동할 수 있는 칸(1)인 경우
            if (newR in 0 until R && newC in 0 until C && maze[newR][newC] == 1 && visit[newR][newC] == 0) {
                // 새 위치를 큐에 추가합니다.
                queue.add(Pair(newR, newC))
                // 새 위치까지의 거리를 현재 위치의 거리에 1을 더해 갱신합니다.
                visit[newR][newC] = visit[curR][curC] + 1
            }
        }
    }

    // 목적지인 (R-1, C-1)까지의 최소 거리를 출력합니다.
    println(visit[R - 1][C - 1])
    
}
