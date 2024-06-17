/**
 * Sum of Square Numbers
 * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 *
 * Input: c = 5
 * Output: true
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 *
 * Input: c = 3
 * Output: false
 *
 */

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        // left와 right를 초기화합니다.
        var left: Long = 0
        var right: Long = Math.sqrt(c.toDouble()).toLong()
        // left가 right보다 작거나 같을 때까지 반복합니다.
        while (left <= right) {
            // 제곱수의 합을 계산합니다.
            val sum = left * left + right * right
            when {
                // 제곱수의 합이 c와 같다면 true를 반환합니다.
                sum == c.toLong() -> return true
                // 제곱수의 합이 c보다 작다면 left를 증가시킵니다.
                sum < c.toLong() -> left++
                // 제곱수의 합이 c보다 크다면 right를 감소시킵니다.
                else -> right--
            }
        }
        return false
    }
}
