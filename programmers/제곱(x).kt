/**
 * 제곱(x)
 * 해결됨
 * 쉬운
 * 주제
 * 프리미엄 잠금 아이콘
 * 회사
 * 힌트
 * 음수가 아닌 정수가 주어지면 x, 가장 가까운 정수로 반올림 한 제곱근을 반환합니다 . 반환되는 정수 도 음수가 아니어야 합니다.x
 *
 * 내장된 지수 함수나 연산자를 사용하면 안 됩니다 .
 *
 * pow(x, 0.5)예를 들어, C++나 x ** 0.5Python 에서는 사용하지 마세요 .
 *
 *
 * 예시 1:
 *
 * 입력: x = 4
 *  출력: 2
 *  설명: 4의 제곱근은 2이므로 2를 반환합니다.
 * 예 2:
 *
 * 입력: x = 8
 *  출력: 2
 *  설명: 8의 제곱근은 2.82842...이고, 이를 가장 가까운 정수로 반올림하므로 2가 반환됩니다.
 */

class Solution {
    fun mySqrt(x: Int): Int {
        var left = 0
        // 2의 31승 - 1의 제곱근은 46340
        var right = 46340
        var ans = 0
        // 이진 탐색
        while (left <= right) {
            val mid = left + (right - left) / 2
            val square = mid.toLong() * mid.toLong()
            when {
                square == x.toLong() -> return mid
                square < x.toLong() -> {
                    ans = mid
                    left = mid + 1
                }
                else -> right = mid - 1
            }
        }
        return ans
    }
}
