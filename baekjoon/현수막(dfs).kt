/**
 * 문제
 * ANT가 처음 알고리즘 대회를 개최하게 되면서 현수막을 내걸었다.
 *
 * 저번 학기 영상처리 수업을 듣고 배웠던 지식을 최대한 응용 해보고 싶은 혁진이는 이 현수막에서 글자가 몇 개인지 알아보는 프로그램을 만들려 한다.
 *
 * 혁진이는 우선 현수막에서 글자인 부분은 1, 글자가 아닌 부분은 0으로 바꾸는 필터를 적용하여 값을 만드는데 성공했다.
 *
 * 그런데 혁진이는 이 값을 바탕으로 글자인 부분 1이 상, 하, 좌, 우, 대각선으로 인접하여 서로 연결되어 있다면 한 개의 글자라고 생각만 하였다.
 *
 * 혁진이가 필터를 적용하여 만든 값이 입력으로 주어졌을 때, 혁진이의 생각대로 프로그램을 구현하면 글자의 개수가 몇 개인지 출력하여라.
 *
 * 입력
 * 첫 번째 줄에는 현수막의 크기인 M와 N가 주어진다. (1 ≤ M, N ≤ 250)
 *
 * 두 번째 줄부터 M+1 번째 줄까지 현수막의 정보가 1과 0으로 주어지며, 1과 0을 제외한 입력은 주어지지 않는다.
 *
 * 출력
 * 혁진이의 생각대로 프로그램을 구현했을 때, 현수막에서 글자의 개수가 몇 개인지 출력하여라.
 */

fun main() = System.`in`.bufferedReader().run {
    // 첫 번째 줄에서 N(행의 수)과 M(열의 수)을 읽어들입니다.
    val (n, m) = readLine().split(" ").map { it.toInt() }
    // 현수막을 2차원 배열로 읽어들입니다.
    val board = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    // 방문 여부를 저장할 2차원 배열을 초기화합니다.
    val visited = Array(n) { BooleanArray(m) }
    val directions = listOf(
        Pair(0, 1), Pair(1, 0), Pair(0, -1), Pair(-1, 0),
        Pair(1, 1), Pair(1, -1), Pair(-1, 1), Pair(-1, -1)
    )

    fun dfs(x: Int, y: Int) {
        visited[x][y] = true
        // 8방향에 대해 반복합니다.
        directions.forEach { (dx, dy) ->
            val nx = x + dx
            val ny = y + dy
            // 새로운 위치가 현수막 내부에 있고, 방문하지 않았으며, 글자인 경우
            if (nx in 0 until n && ny in 0 until m && !visited[nx][ny] && board[nx][ny] == 1) {
                dfs(nx, ny)
            }
        }
    }

    var count = 0
    // 모든 위치에 대해 반복합니다.
    for (x in 0 until n) {
        for (y in 0 until m) {
            if (!visited[x][y] && board[x][y] == 1) {
                count++
                dfs(x, y)
            }
        }
    }

    println(count)
}
