/**
* 반복 문자가 없는 가장 긴 부분 문자열
* 문자열 s가 주어졌을 때, 반복 문자가 없는 가장 긴
* 부분 문자열
* 의 길이를 구하시오.
*
*
*
* 예제 1:
*
* 입력: s = "abcabcbb"
* 출력: 3
* 설명: 답은 "abc"이고 길이는 3입니다.
* 예제 2:
*
* 입력: s = "bbbbb"
* 출력: 1
* 설명: 답은 "b"이고 길이는 1입니다.
* 예제 3:
*
* 입력: s = "pwwkew"
* 출력: 3
* 설명: 답은 "wke"이고 길이는 3입니다.
* 답은 부분 문자열이어야 하며, "pwke"는 부분 문자열이 아니라 부분 시퀀스입니다.
*
*/


class Solution {
    fun lengthOfLongestSubstring(s: String): Int = slidingWindow(s)

    fun slidingWindow(s: String): Int {
        val n = s.length
        val set = mutableSetOf<Char>()
        var anser = 0
        var i = 0
        var j = 0
        while (i < n && j < n) {
            if (!set.contains(s[j])) {
                set.add(s[j++])
                // answer에서 j - i를 비교하여 더 큰 값을 저장합니다.
                answer = answer.coerceAtLeast(j - i)
            } else {
                set.remove(s[i++])
            }
        }
        return answer
    }
}
