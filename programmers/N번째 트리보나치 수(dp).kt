/**
 * 트리보나치 수열 Tn 은 다음과 같이 정의됩니다.
 *
 * T 0 = 0, T 1 = 1, T 2 = 1, 그리고 T n+3 = T n + T n+1 + T n+2 for n >= 0.
 *
 * 가 주어지면 Tnn 값을 반환합니다 .
 */

class Solution {
    fun tribonacci(n: Int): Int {
        // dp 배열을 초기화합니다. 크기는 38로 설정합니다.
        // 트리보나치 수열의 특성상, n이 0, 1, 2일 때의 값을 설정해 줍니다.
        // 0일 때는 0, 1과 2일 때는 1로 설정합니다.
        // 그 외의 경우는 -1로 초기화하여, 아직 계산되지 않았음을 표시합니다.
        val dp = IntArray(n + 1) {
            when (it) {
                0 -> 0
                1, 2 -> 1
                else -> -1
            }
        }

        // n이 3 이상일 경우, 트리보나치 수열의 값을 계산합니다.
        // dp[i]는 dp[i-1], dp[i-2], dp[i-3]의 합으로 구할 수 있습니다.
        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }

        // 계산된 트리보나치 수열의 n번째 값을 반환합니다.
        return dp[n]
    }
}
