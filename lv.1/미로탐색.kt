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
    val (R, C) = readLine().split(" ").map { it.toInt() }
    val maze = List(R) { readLine().map { it.toString().toInt() } }

    val visit = List(R) { MutableList(C) { 0 } }
    val directions = listOf(Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0))
    val queue = ArrayDeque<Pair<Int, Int>>().apply { add(Pair(0, 0)) }
    visit[0][0] = 1

    while (queue.isNotEmpty()) {
        val (curR, curC) = queue.removeFirst()

        for ((dr, dc) in directions) {
            val newR = curR + dr
            val newC = curC + dc
            if (newR in 0 until R && newC in 0 until C && maze[newR][newC] == 1 && visit[newR][newC] == 0) {
                queue.add(Pair(newR, newC))
                visit[newR][newC] = visit[curR][curC] + 1
            }
        }
    }

    println(visit[R - 1][C - 1])
}
