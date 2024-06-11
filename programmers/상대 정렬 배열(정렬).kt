/**
 * 상대 정렬 배열
 *
 * 두 개의 배열 arr1및 arr2가 주어지면 의 요소는 arr2서로 다르며 의 모든 요소 arr2는 에도 있습니다 arr1.
 *
 * arr1항목의 상대적 순서가 arr1와 동일 하도록 의 요소를 정렬합니다 arr2. 에 나타나지 않는 요소는 오름차순 으로 arr2맨 마지막에 배치되어야 합니다 .arr1
 *
 *
 */
class Solution {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        val sortedArr1 = mutableListOf<Int>()
        val rest = mutableListOf<Int>()

        // arr2에 있는 숫자들을 순서대로 정렬합니다.
        for (num in arr2) {
            sortedArr1.addAll(arr1.filter { it == num })
        }
        // arr2에 없는 숫자들을 정렬합니다.
        rest.addAll(arr1.filter { it !in arr2 }.sorted())

        // 정렬된 arr1과 나머지 숫자들을 합쳐 반환합니다.
        return (sortedArr1 + rest).toIntArray()
    }
}
