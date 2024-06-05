/**
 * 1002. 공통 문자 찾기
 * 
 * 문자열 배열이 주어지면 (중복 포함) 내의 모든 문자열에 나타나는 모든 문자의 배열을words 반환합니다 . 어떤 순서 로든 답변을 반환할 수 있습니다 .words
 *
 * 예시 1:
 *
 * 입력: 단어 = ["bella","label","roller"]
 *  출력: ["e","l","l"]
 * 예 2:
 *
 * 입력: 단어 = ["cool","lock","cook"]
 *  출력: ["c","o"]
 * */
class Solution {
    fun commonChars(words: Array<String>): List<String> {
        // 결과 리스트 초기화
        val result = mutableListOf<String>()

        // 알파벳 'a'부터 'z'까지 순회
        for (c in 'a'..'z') {
            // 각 단어에서 문자 c의 등장 횟수 중 최소값 찾기
            val minCount = words.map { it.count { it == c } }.minOrNull() ?: 0

            // 최소 등장 횟수만큼 문자 c를 결과 리스트에 추가
            repeat(minCount) { result.add(c.toString()) }
        }

        // 결과 리스트 반환
        return result
    }
}
