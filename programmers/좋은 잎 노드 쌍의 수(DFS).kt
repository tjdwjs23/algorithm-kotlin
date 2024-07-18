/**
 * 좋은 잎 노드 쌍의 수
 * 힌트
 * 당신은 이진 트리의 루트와 정수 거리를 주어진다. 이진 트리의 두 개의 다른 잎 노드 쌍은 그들 사이의 최단 경로 길이가 거리 이하인 경우 좋은 것으로 간주된다.
 * 트리 내의 좋은 잎 노드 쌍의 수를 반환하시오.
 */

class Solution {
    fun countPairs(root: TreeNode?, distance: Int): Int {
        var ans = 0 // 좋은 잎 노드 쌍의 수를 저장할 변수

        // DFS 함수
        fun dfs(node: TreeNode?): IntArray {
            if (node == null) return IntArray(11) // 노드가 null이면 길이가 11인 배열을 반환

            // 노드가 잎 노드인 경우
            if (node.left == null && node.right == null) {
                val arr = IntArray(11)
                arr[1] = 1 // 거리가 1인 경우 1개의 잎 노드가 있음
                return arr
            }

            // 왼쪽 서브트리와 오른쪽 서브트리를 각각 DFS 탐색
            val left = dfs(node.left)
            val right = dfs(node.right)

            // 좋은 잎 노드 쌍의 수를 계산
            for (i in 1..10) {
                for (j in 1..10) {
                    if (i + j <= distance) {
                        ans += left[i] * right[j] // 거리가 distance 이하인 경우 좋은 잎 노드 쌍의 수를 증가시킴
                    }
                }
            }

            // 현재 노드의 거리 정보를 담은 배열을 반환
            val arr = IntArray(11)
            for (i in 1..10) {
                arr[i] = left[i - 1] + right[i - 1]
            }
            return arr
        }

        dfs(root) // 루트 노드부터 DFS 탐색 시작
        return ans // 좋은 잎 노드 쌍의 수 반환
    }
}
