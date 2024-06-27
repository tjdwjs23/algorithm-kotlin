/**
 * 별 그래프의 중심 찾기
 * 에서 까지 레이블이 지정된 노드 로 구성된 방향이 없는 별 그래프 가 있습니다 . 별형 그래프는 하나의 중심 노드 가 있고 중심 노드를 다른 모든 노드와 연결하는 정확히 가장자리가 있는 그래프입니다.n1n n - 1
 *
 * edges각각 노드 와 사이에 가장자리가 있음을 나타내는 2D 정수 배열이 제공됩니다 . 주어진 별 그래프의 중심을 반환합니다.edges[i] = [ui, vi]uivi
 */

class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        // 별 그래프의 중심은 두 간선의 교집합입니다.
        val (a, b) = edges[0]
        val (c, d) = edges[1]

        // 두 간선의 교집합을 찾아 반환합니다.
        return if (a == c || a == d) a else b
    }
}
