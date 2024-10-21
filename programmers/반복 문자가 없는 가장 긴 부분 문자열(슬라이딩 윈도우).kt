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
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        var start = 0
        val charIndexMap = mutableMapOf<Char, Int>()

        for (end in s.indices) {
            val currentChar = s[end]

            // 중복된 문자가 있으면 start를 이동시킴
            if (charIndexMap.containsKey(currentChar)) {
                // start를 중복된 문자 이후로 이동시킴
                start = maxOf(start, charIndexMap[currentChar]!! + 1)
            }

            // 현재 문자의 위치를 갱신
            charIndexMap[currentChar] = end

            // 윈도우 크기를 계산하여 최대값 갱신
            maxLength = maxOf(maxLength, end - start + 1)
        }

        return maxLength
    }
}
