/**
 * 문제
 * 체스판은 8×8크기이고, 검정 칸과 하얀 칸이 번갈아가면서 색칠되어 있다. 가장 왼쪽 위칸 (0,0)은 하얀색이다. 체스판의 상태가 주어졌을 때, 하얀 칸 위에 말이 몇 개 있는지 출력하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄부터 8개의 줄에 체스판의 상태가 주어진다. ‘.’은 빈 칸이고, ‘F’는 위에 말이 있는 칸이다.
 */

fun main() = System.`in`.bufferedReader().run {
    var count = 0
    for (i in 0 until 8) {
        // 입력받은 문자열을 한 줄씩 읽어 옵니다.
        val lines = readLine()
        lines.forEachIndexed { j, line ->
            // i행 과 j열의 합이 짝수이고, 해당 칸이 'F'인 경우 카운트를 증가시킵니다.
            if (((i + j) % 2 == 0) && (line == 'F')) count++
        }
    }
    println(count)
}
