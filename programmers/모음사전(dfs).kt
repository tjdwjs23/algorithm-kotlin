/**
 * 문제 설명
 * 사전에 알파벳 모음 'A', 'E', 'I', 'O', 'U'만을 사용하여 만들 수 있는, 길이 5 이하의 모든 단어가 수록되어 있습니다. 사전에서 첫 번째 단어는 "A"이고, 그다음은 "AA"이며, 마지막 단어는 "UUUUU"입니다.
 *
 * 단어 하나 word가 매개변수로 주어질 때, 이 단어가 사전에서 몇 번째 단어인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * word의 길이는 1 이상 5 이하입니다.
 * word는 알파벳 대문자 'A', 'E', 'I', 'O', 'U'로만 이루어져 있습니다.
 */


class Solution {
    // 모음 배열 정의
    val arr = arrayOf("A", "E", "I", "O", "U")
    // 생성된 문자열을 저장할 리스트
    val result = mutableListOf<String>()

    // 주어진 단어의 순서를 찾는 함수
    fun solution(word: String): Int {
        // DFS를 사용하여 모든 가능한 문자열 생성
        dfs("")
        // 생성된 문자열 리스트를 순회하며 주어진 단어의 위치 찾기
        result.forEachIndexed { idx, s ->
            // 주어진 단어와 같은 문자열을 찾으면 그 위치 반환
            if(s == word) return idx
        }
        // 주어진 단어를 찾지 못한 경우 -1 반환
        return -1
    }

    // DFS를 사용하여 가능한 모든 문자열을 생성하는 함수
    fun dfs(str: String) {
        // 생성된 문자열의 길이가 5를 초과하는 경우 더 이상 문자를 추가하지 않고 반환
        if(str.length > 5) return
        // 현재 문자열을 결과 리스트에 추가
        result.add(str)
        // 모음 배열을 순회하며 현재 문자열에 각 모음을 추가하여 재귀 호출
        arr.forEach { a ->
            dfs(str + a)
        }
    }
}