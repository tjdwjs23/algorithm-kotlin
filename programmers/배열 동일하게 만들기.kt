/**
 * 서브어레이를 반전하여 두 개의 어레이를 동일하게 만들기
 *
 * 힌트
 * target길이가 같은 두 개의 정수 배열 과 가 주어집니다 arr. 한 단계에서 비어 있지 않은 모든 하위 배열을 선택 하여 arr역순으로 만들 수 있습니다. 원하는 수의 단계를 만들 수 있습니다.
 *
 * 동등하거나  그렇지 않은 것을 true 만들 수 있으면 반환해 주세요 .arr target false
 */

class Solution {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        if (target.size != arr.size) return false

        target.sort()
        arr.sort()

        return target.contentEquals(arr)
    }
}