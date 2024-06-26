/**
 * 문제
 * 지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.
 * 체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.
 * 보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
 *
 * 출력
 * 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
 */

fun main() = System.`in`.bufferedReader().run {
    // 입력받은 높이와 너비를 공백으로 분리하여 정수로 변환
    val (h, w) = readLine().split(" ").map { it.toInt() }
    // h개의 줄을 읽어서 체스판 리스트 생성
    val list = List(h) { readLine() }

    // 특정 시작 위치에서 8x8 체스판을 만들 때, 바꿔야 할 최소 칸 수를 계산하는 함수
    fun calculateMinChange(i: Int, j: Int): Int {
        var count = 0 // 바꿔야하는 칸의 수
        // 주어진 범위 내에서 체스판을 확인
        for (x in i until i + 8) {
            for (y in j until j + 8) {
                // (x+y)의 합이 짝수일 때 'W'가 아니면 또는 홀수일 때 'W'이면 카운트++
                if (((x + y) % 2 == 0 && list[x][y] != 'W') || ((x + y) % 2 != 0 && list[x][y] == 'W')) {
                    count++
                }
            }
        }
        // 바꿔야 할 칸의 수와 바꾸지 않아도 되는 칸의 수 중 작은 값을 반환
        return minOf(count, 64 - count)
    }

    var min = h * w // 가능한 최대 변경 횟수로 초기화

    // 모든 가능한 8x8 체스판 시작 위치에 대해 반복
    for (i in 0..h - 8) {
        for (j in 0..w - 8) {
            // 최소 변경 횟수를 업데이트
            min = minOf(min, calculateMinChange(i, j))
        }
    }
    print(min) // 계산된 최소 변경 횟수 출력
}
