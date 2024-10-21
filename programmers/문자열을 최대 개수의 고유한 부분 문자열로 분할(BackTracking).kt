/**
 * 문자열이 주어지면  s, 해당 문자열을 분할할 수 있는 고유한 부분 문자열의 최대 개수를  반환합니다 .
 * 
 * 문자열을 비어 있지 않은 부분 문자열s 의 목록으로  분할할 수 있으며  , 부분 문자열을 연결하면 원래 문자열이 형성됩니다. 그러나 모든 부분 문자열이 고유 하도록 분할해야 합니다 .
 * 
 * 부분 문자열 은 문자열 내의 연속된 문자 시퀀스입니다.
*/

class Solution {
    fun maxUniqueSplit(s: String): Int {
        var maxUniqueCount = 0 // 최대 고유 부분 문자열 개수 저장 변수

        // 백트래킹 함수 정의
        fun backtrack(uniqueSubs: List<String>, currentSub: String, index: Int) {
            // 문자열의 끝에 도달한 경우
            if (index == s.length) {
                // 현재 부분 문자열이 비어있지 않으면 maxUniqueCount 갱신
                if (currentSub.isEmpty()) {
                    maxUniqueCount = maxOf(maxUniqueCount, uniqueSubs.size)
                }
                return
            }

            // 현재 문자 추가
            val newSub = currentSub + s[index]

            // 새로 만든 부분 문자열이 고유한 경우
            if (!uniqueSubs.contains(newSub)) {
                // 고유 부분 문자열 목록에 추가하고 다음 문자로 진행
                backtrack(uniqueSubs + newSub, "", index + 1)
            }
            // 현재 부분 문자열을 계속 확장하여 다음 문자로 진행
            backtrack(uniqueSubs, newSub, index + 1)
        }

        // 백트래킹 시작
        backtrack(listOf(), "", 0)

        return maxUniqueCount // 최종적으로 최대 고유 부분 문자열 개수 반환
    }
}
