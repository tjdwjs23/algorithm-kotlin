/**
* s소문자와 정수로 구성된 문자열이 제공됩니다 k. 다음 조건이 충족되면 문자열을 t 이상적 이라고 부릅니다 .
* t문자열의 하위 시퀀스 입니다 s.
* 에서 인접한 두 글자 의 알파벳 순서의 절대차는 . t보다 작거나 같습니다 k.
* 가장 긴 이상적인 문자열 의 길이를 반환합니다 .
* 하위 시퀀스 는 나머지 문자의 순서를 변경하지 않고 일부 문자를 삭제하거나 문자를 전혀 삭제하지 않고 다른 문자열에서 파생될 수 있는 문자열입니다.
* 알파벳 순서는 순환적이지 않습니다 .'a' 예를 들어 과 의 알파벳 순서의 절대차는 가 아니라 'z'입니다 .251
*/


class Solution {
    fun longestIdealString(s: String, k: Int): Int {
        val dp = IntArray(128) // 각 문자의 ASCII 코드 값을 인덱스로 사용하여, 해당 문자로 끝나는 이상적인 문자열의 최대 길이를 저장하기 위한 배열
        var maxLength = 0 // 지금까지 발견된 이상적인 문자열의 최대 길이를 저장

        for (char in s) { // 입력된 문자열 s의 각 문자에 대해 반복
            var maxLenForChar = 1 // 현재 문자로 끝나는 이상적인 문자열의 최대 길이를 1로 초기화
            // 현재 문자에서 k만큼 떨어진 범위 내의 모든 문자에 대해 최대 길이 업데이트 시도
            for (i in maxOf('a'.code, char.code - k)..minOf('z'.code, char.code + k)) {
                maxLenForChar = maxOf(maxLenForChar, dp[i] + 1) // 현재 문자를 포함하여 업데이트할 수 있는 최대 길이를 계산
            }
            dp[char.code] = maxOf(dp[char.code], maxLenForChar) // dp 배열을 현재 문자를 기준으로 업데이트
            maxLength = maxOf(maxLength, maxLenForChar) // 전체 이상적인 문자열의 최대 길이 업데이트
        }

        return maxLength // 계산된 최대 길이 반환
    }
}
