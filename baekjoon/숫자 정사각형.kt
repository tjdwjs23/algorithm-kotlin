/**
 * 문제
 * N×M크기의 직사각형이 있다. 각 칸에는 한 자리 숫자가 적혀 있다. 이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오. 이때, 정사각형은 행 또는 열에 평행해야 한다.
 *
 * 입력
 * 첫째 줄에 N과 M이 주어진다. N과 M은 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 수가 주어진다.
 *
 * 출력
 * 첫째 줄에 정답 정사각형의 크기를 출력한다.
 */

fun main() = System.`in`.bufferedReader().run {
    // N과 M을 입력받습니다.
    val (N, M) = readLine().split(" ").map { it.toInt() }
    // 직사각형의 각 칸에 적힌 수를 입력받습니다.
    val arr = Array(N) { readLine() }
    // 정사각형의 크기를 저장할 변수를 초기화합니다.
    var size = 1

    // 직사각형의 각 칸을 순회하며 정사각형을 찾습니다.
    for (i in 0 until N) {
        for (j in 0 until M) {
            // 현재 칸의 숫자를 기준으로 정사각형을 찾습니다.
            for (k in 1 until minOf(N - i, M - j)) {
                // 대각선 방향의 숫자가 같은 경우, 정사각형의 크기를 갱신합니다.
                if (arr[i][j] == arr[i + k][j] && arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j + k]) {
                    size = maxOf(size, k + 1)
                }
            }
        }
    }

    println(size * size)  // 정사각형의 크기를 출력합니다.
}
