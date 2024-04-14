/**
 * n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때, 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들 때 필요한 최소 비용을 return 하도록 solution을 완성하세요.
 * 다리를 여러 번 건너더라도, 도달할 수만 있으면 통행 가능하다고 봅니다. 예를 들어 A 섬과 B 섬 사이에 다리가 있고, B 섬과 C 섬 사이에 다리가 있으면 A 섬과 C 섬은 서로 통행 가능합니다.
 * 제한사항
 * 섬의 개수 n은 1 이상 100 이하입니다.
 * costs의 길이는 ((n-1) * n) / 2이하입니다.
 * 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
 * 같은 연결은 두 번 주어지지 않습니다. 또한 순서가 바뀌더라도 같은 연결로 봅니다. 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
 * 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
 * 연결할 수 없는 섬은 주어지지 않습니다.
 */

class Solution {
    fun solution(n: Int, costs: Array<IntArray>): Int {
        // 비용을 기준으로 간선을 오름차순 정렬합니다.
        val sortedCosts = costs.sortedBy { it[2] }
        // 각 노드의 부모 노드를 자기 자신으로 초기화합니다.
        val parent = IntArray(n) { it }

        // 주어진 노드의 루트 노드를 찾는 함수입니다.
        fun find(u: Int): Int {
            // 루트 노드가 자기 자신이 아니면, 루트 노드를 찾을 때까지 재귀적으로 호출합니다.
            if (u != parent[u]) parent[u] = find(parent[u])
            return parent[u]
        }

        // 두 노드를 연결하는 함수입니다. 이미 같은 트리에 속해있다면 연결하지 않습니다.
        fun union(u: Int, v: Int): Boolean {
            val rootU = find(u)
            val rootV = find(v)
            // 두 노드의 루트 노드가 같다면, 이미 같은 트리에 속해있으므로 연결하지 않습니다.
            if (rootU == rootV) return false
            // 두 노드를 하나의 트리로 합칩니다. 여기서는 rootV를 rootU의 부모로 설정합니다.
            parent[rootU] = rootV
            return true
        }

        // 최소 비용을 계산합니다.
        var answer = 0
        // 정렬된 간선 리스트를 순회하면서
        for ((s, e, c) in sortedCosts) {
            // 두 노드를 연결할 수 있다면(즉, 이미 같은 트리에 속해있지 않다면),
            // 해당 간선의 비용을 더하고 두 노드를 연결합니다.
            if (union(s, e)) {
                answer += c
            }
        }
        // 모든 섬을 최소 비용으로 연결하는데 필요한 비용을 반환합니다.
        return answer
    }
}
