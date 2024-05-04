/**
 * 머쓱이는 태어난 지 11개월 된 조카를 돌보고 있습니다. 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과 네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고 연속해서 같은 발음을 하는 것을 어려워합니다.
 * 문자열 배열 babbling이 매개변수로 주어질 때, 머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
 */

class Solution {
    // 정규식을 사용하여 발음을 판별합니다.
    val ableRegex = "aya|ye|woo|ma".toRegex()
    // 연속해서 같은 발음을 하는 것을 판별하기 위한 정규식입니다.
    val unableRegex = "ayaaya|yeye|woowoo|mama".toRegex()
    fun solution(babbling: Array<String>): Int =
        // 발음이 가능하고, 연속해서 같은 발음을 하지 않는 경우를 카운트합니다.
        babbling.count {
            !it.contains(unableRegex) && it.replace(ableRegex, "").isEmpty()
        }
}