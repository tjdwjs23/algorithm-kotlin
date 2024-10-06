/**
 * 유효한 팰린드롬
 *
 * 주제
 * 모든 대문자를 소문자로 바꾸고 모든 영숫자가 아닌 문자를 제거한 후 앞뒤로 읽어도 같은 경우 구문은 팰린드롬 입니다. 영숫자 문자에는 문자와 숫자가 포함됩니다.
 *
 * 문자열이 주어지면 팰 린드 롬이면 true 반환하고 그렇지 않으면 false 반환 합니다 .
 */
class Solution {
    // 주어진 문자열 s가 회문인지 여부를 판단하는 함수
    fun isPalindrome(s: String): Boolean {
        // 문자열의 시작 인덱스
        var left = 0
        // 문자열의 끝 인덱스
        var right = s.length - 1

        // 두 포인터가 서로 교차할 때까지 반복
        while (left < right) {
            // 왼쪽 포인터가 가리키는 문자가 알파벳 또는 숫자가 아닐 경우
            while (left < right && !s[left].isLetterOrDigit()) {
                left++ // 왼쪽 포인터를 오른쪽으로 이동
            }
            // 오른쪽 포인터가 가리키는 문자가 알파벳 또는 숫자가 아닐 경우
            while (left < right && !s[right].isLetterOrDigit()) {
                right-- // 오른쪽 포인터를 왼쪽으로 이동
            }

            // 현재 왼쪽과 오른쪽 포인터가 가리키는 문자를 비교 (대소문자 무시)
            if (s[left].toLowerCase() != s[right].toLowerCase()) {
                return false // 문자가 일치하지 않으면 회문이 아님
            }

            // 포인터를 각각 한 칸씩 이동
            left++
            right--
        }

        // 모든 문자들이 대칭이라면 회문이므로 true 반환
        return true
    }
}
