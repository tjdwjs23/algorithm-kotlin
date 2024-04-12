/**
 * 설명
 * 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
 * N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.
 *
 * 입력
 * 첫 줄에 자연수 N이 주어진다.(2<=N<=50)
 * 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
 *
 * 출력
 * 최대합을 출력합니다.
 */


fun main() = System.`in`.bufferedReader().run {
    val n = readLine().toInt()
    val grid = List(n) { readLine().split(' ').map { it.toInt() } }
    var maxSum = 0

    // 행과 열의 합 계산
    (0 until n).forEach { index ->
        val rowSum = grid[index].sum()
        val colSum = grid.map { it[index] }.sum()

        // 최대 합 갱신
        maxSum = maxOf(maxSum, rowSum, colSum)
    }

    // 대각선 합 계산 및 최대 합 갱신
    val diagonalSum1 = (0 until n).sumBy { grid[it][it] }
    val diagonalSum2 = (0 until n).sumBy { grid[it][n - 1 - it] }
    maxSum = maxOf(maxSum, diagonalSum1, diagonalSum2)

    println(maxSum)
}
