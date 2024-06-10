/**
 * 높이체커
 *
 * 힌트
 * 한 학교에서 모든 학생들의 연례 사진을 찍으려고 합니다. 학생들은 키가 감소하지 않는 순서 로 한 줄로 서도록 요청받습니다 . 이 순서는 줄에 선 학생 의 예상 키인 expected정수 배열로 표시됩니다 .expected[i]ith
 *
 * 학생들이 현재 서 있는 순서heights 를 나타내는 정수 배열이 제공됩니다 . 각각은 줄에 있는 학생 의 키입니다 ( 인덱스 0 ).heights[i]ith
 *
 * 여기서 인덱스 수를 반환 합니다 heights[i] != expected[i].
 */

class Solution {
    fun heightChecker(heights: IntArray): Int {
        // 정렬된 배열을 만들어서 비교합니다.
        val expected = heights.sortedArray()
        // 두 배열을 비교하여 다른 요소의 개수를 셉니다.
        return heights.indices.count { heights[it] != expected[it] }
    }
}
