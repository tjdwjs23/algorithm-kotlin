/**
 * 이진 검색 트리는 다음과 같은 세 가지 조건을 만족하는 이진 트리이다.
 * 노드의 왼쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 작다.
 * 노드의 오른쪽 서브트리에 있는 모든 노드의 키는 노드의 키보다 크다.
 * 왼쪽, 오른쪽 서브트리도 이진 검색 트리이다.
 * 전위 순회 (루트-왼쪽-오른쪽)은 루트를 방문하고, 왼쪽 서브트리, 오른쪽 서브 트리를 순서대로 방문하면서 노드의 키를 출력한다. 
 * 후위 순회 (왼쪽-오른쪽-루트)는 왼쪽 서브트리, 오른쪽 서브트리, 루트 노드 순서대로 키를 출력한다. 예를 들어, 위의 이진 검색 트리의 전위 순회 결과는 50 30 24 5 28 45 98 52 60 이고, 후위 순회 결과는 5 28 24 45 30 60 52 98 50 이다.
 * 이진 검색 트리를 전위 순회한 결과가 주어졌을 때, 이 트리를 후위 순회한 결과를 구하는 프로그램을 작성하시오.
 */

// 메인 함수
fun main() = System.`in`.bufferedReader().run {
    // 입력을 받아 각 줄을 정수로 변환하여 리스트로 만듦
    val tree = readLines().map { it.toInt() }

    // 변환된 리스트를 사용하여 전위 순회 결과를 후위 순회 결과로 변환하는 함수 호출
    pre2post(tree, 0, tree.size)
}

/**
 * 주어진 전위 순회 결과를 후위 순회 결과로 변환하여 출력하는 함수.
 *
 * @param tree 전위 순회 결과가 담긴 정수 리스트.
 * @param start 현재 처리할 서브트리의 시작 인덱스.
 * @param end 현재 처리할 서브트리의 끝 인덱스.
 */
fun pre2post(tree: List<Int>, start: Int, end: Int) {
    // 시작 인덱스와 끝 인덱스가 같으면 더 이상 처리할 노드가 없으므로 함수 종료
    if (start == end)
        return

    // 현재 서브트리의 루트 노드 값
    val root = tree[start]

    // 루트 노드의 바로 다음 인덱스부터 시작하여 오른쪽 자식 노드의 시작 인덱스를 찾음
    var mid = start + 1
    while (mid < end && tree[mid] < root)
        mid++

    // 왼쪽 서브트리에 대해 재귀적으로 함수 호출
    pre2post(tree, start + 1, mid)
    // 오른쪽 서브트리에 대해 재귀적으로 함수 호출
    pre2post(tree, mid, end)
    
    // 후위 순회 결과에 따라 현재 루트 노드를 처리 (출력)
    println("$root")
}
