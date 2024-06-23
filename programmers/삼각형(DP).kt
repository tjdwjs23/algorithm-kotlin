/**
 * 배열이 주어지면 위에서 아래로의 최소 경로 합계를triangle 반환합니다 .
 *
 * 각 단계마다 아래 행의 인접한 번호로 이동할 수 있습니다. 더 공식적으로 말하면, i현재 행의 인덱스에 있으면 다음 행의 인덱스 i나 인덱스 로 이동할 수 있습니다.i + 1
 */

class Solution {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        // dp 배열 초기화: 삼각형의 마지막 행으로 dp 배열을 초기화합니다.
        // 이는 바닥에서 시작하여 위로 올라가면서 최소 경로 합을 계산하기 위함입니다.
        val dp = triangle.last().toMutableList()

        // 바닥부터 위로 올라가며 최소 경로 합계를 갱신합니다.
        // 삼각형의 끝에서 두 번째 행부터 시작하여 맨 위 행까지 반복합니다.
        (triangle.size - 2 downTo 0).forEach { row ->
            triangle[row].forEachIndexed { col, value ->
                // 현재 위치에서 아래쪽으로 내려갈 수 있는 두 경로 중 더 작은 경로를 선택하고,
                // 현재 위치의 값과 더합니다. 그 결과를 dp 배열에 저장합니다.
                // 이렇게 함으로써, 각 위치에서의 최소 경로 합을 계산할 수 있습니다.
                dp[col] = value + minOf(dp[col], dp[col + 1])
            }
        }
        // 최종적으로, dp 배열의 첫 번째 요소에는 삼각형의 꼭대기에서 바닥까지 내려오는
        // 경로 중 최소 경로의 합이 저장됩니다.
        return dp[0]
    }

}
