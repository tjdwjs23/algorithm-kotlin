/**
 * 주어진 설명을 바탕으로 이진 트리를 생성하는 함수입니다.
 *
 * 힌트:
 * - 2차원 정수 배열 descriptions가 주어집니다.
 * - descriptions[i] = [parenti, childi, isLefti]는 다음을 의미합니다:
 *   - parenti는 childi의 부모 노드입니다.
 *   - isLefti가 1이면 childi는 parenti의 왼쪽 자식 노드입니다.
 *   - isLefti가 0이면 childi는 parenti의 오른쪽 자식 노드입니다.
 * - 이 설명을 바탕으로 이진 트리를 구성하고, 루트 노드를 반환합니다.
 */
class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        // 모든 노드를 저장하는 맵
        val nodeMap: MutableMap<Int, TreeNode> = mutableMapOf()

        // descriptions 배열을 순회하며 TreeNode 객체를 생성하고 맵에 추가
        // 각 노드의 값(데이터)을 기준으로 TreeNode 객체를 생성하고 맵에 저장합니다.
        // 이렇게 하면 나중에 부모-자식 관계를 설정할 때 쉽게 접근할 수 있습니다.
        for (description in descriptions) {
            nodeMap.getOrPut(description[0]) { TreeNode(description[0]) }
            nodeMap.getOrPut(description[1]) { TreeNode(description[1]) }
        }

        // descriptions 배열을 순회하며 TreeNode 객체의 left, right 포인터 설정
        // 각 description에 대해 부모 노드와 자식 노드를 찾아 left 또는 right 포인터를 설정합니다.
        // isLeft 값에 따라 왼쪽 자식 노드 또는 오른쪽 자식 노드로 설정합니다.
        for (description in descriptions) {
            val parent = nodeMap[description[0]]!!
            val child = nodeMap[description[1]]!!
            if (description[2] == 1) {
                parent.left = child
            } else {
                parent.right = child
            }
        }

        // 루트 노드 찾기
        // 모든 노드의 키 집합에서 자식 노드들의 키를 제거하면 남은 키가 루트 노드의 키입니다.
        val rootSet = nodeMap.keys.toMutableSet()
        for (description in descriptions) {
            rootSet.remove(description[1])
        }
        return rootSet.firstOrNull()?.let { nodeMap[it] }
    }
}
