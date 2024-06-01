/**
 * 문자열이 제공됩니다 s. 문자열의 점수 는 인접한 문자의 ASCII 값 간의 절대 차이의 합으로 정의됩니다 .
 *
 * 의 점수를 반환합니다 . s
 */

class Solution {
    fun scoreOfString(s: String): Int {
        var score = 0
        // 문자열의 각 문자에 대해 인접한 문자의 ASCII 값 차이를 계산하여 절대값을 더합니다.
        for (i in 0 until s.length - 1) {
            score += (s[i].toInt() - s[i + 1].toInt()).absoluteValue
        }
        return score
    }
}