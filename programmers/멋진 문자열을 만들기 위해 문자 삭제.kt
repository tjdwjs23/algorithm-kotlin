/**
 * 멋진 문자열 은 연속된 세 문자가 서로 같지 않은 문자열입니다 .
 * 
 * 문자열이 주어지면 s, 가능한 최소한 의 문자만 삭제하여 멋지게s 만들어 보세요 .
 * 
 * 삭제 후 최종 문자열을 반환합니다 . 답은 항상 고유 할 것임을 보여줄 수 있습니다 .
*/

class Solution {
    fun makeFancyString(s: String): String {
        val answer = StringBuilder()
        var count = 1
        answer.append(s[0])
        for (i in 1 until s.length) {
            if (s[i] == s[i - 1]) {
                count++
            } else {
                count = 1
            }

            if (count < 3) {
                answer.append(s[i])
            }
        }
        return answer.toString()
    }
}
