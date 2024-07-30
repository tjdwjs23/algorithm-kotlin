/**
 *  문자열을 균형 있게 만들기 위한 최소 삭제 횟수를 계산하는 클래스
 *
 *  문자열 s를 받아 균형을 맞추기 위해 필요한 최소 삭제 횟수를 반환하는 함수
 *
 *  @param s 균형을 맞춰야 하는 문자열 (오직 'a'와 'b'로만 구성됨)
 *  @return 균형을 맞추기 위해 삭제해야 할 최소 문자 수
 *
 */

class Solution {
    fun minimumDeletions(s: String): Int {
        // 문자열의 길이를 n에 저장
        val n = s.length

        // prefixSum 배열을 생성하여 각 인덱스까지의 'b' 개수를 저장
        val prefixSum = IntArray(n + 1)

        // prefixSum 배열을 채우기
        for (i in 1..n) {
            // 현재 인덱스의 'b' 개수를 누적하여 저장
            prefixSum[i] = prefixSum[i - 1] + if (s[i - 1] == 'b') 1 else 0
        }

        // 최소 삭제 횟수를 초기값 n으로 설정
        var answer = n

        // 0부터 n까지 반복하며 각 경우의 삭제 횟수 계산
        for (i in 0..n) {
            // 현재 i까지의 'b' 개수 + i 이후의 'a' 개수 계산
            // prefixSum[i]는 i까지의 'b' 개수
            // n - i는 i 이후의 총 문자 수
            // (prefixSum[n] - prefixSum[i])는 i 이후의 'b' 개수
            // 즉, n - i - (prefixSum[n] - prefixSum[i])는 i 이후의 'a' 개수
            answer = minOf(answer, prefixSum[i] + n - i - (prefixSum[n] - prefixSum[i]))
        }

        // 최종적으로 계산된 최소 삭제 횟수를 반환
        return answer
    }
}
