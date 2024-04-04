/**
 * 초기에 $n+1$개의 집합 $\{0\}, \{1\}, \{2\}, \dots , \{n\}$이 있다. 여기에 합집합 연산과, 두 원소가 같은 집합에 포함되어 있는지를 확인하는 연산을 수행하려고 한다.
 * 집합을 표현하는 프로그램을 작성하시오.
 */

fun main() = System.`in`.bufferedReader().run {
    // 첫 번째 줄에서 n(노드의 수), m(연산의 수)을 읽어옵니다.
    val (n, m) = readLine()!!.split(' ').map { it.toInt() }
    // 노드 배열을 초기화합니다. 각 노드의 부모를 자기 자신으로 설정합니다.
    val node = IntArray(n + 1) { it }

    // find 함수: 특정 원소가 속한 집합을 찾습니다.
    fun find(b:Int): Int{
        // 노드의 부모가 자기 자신이라면 해당 노드를 반환합니다.
        if(node[b]==b) return b
        // 그렇지 않다면, 노드의 부모를 찾아 재귀적으로 호출합니다.
        node[b] = find(node[b])
        return node[b]
    }

    // union 함수: 두 원소가 속한 집합을 합칩니다.
    fun union(b:Int, c:Int){
        // 두 노드의 루트 노드를 찾아 한쪽의 부모를 다른 한쪽으로 설정합니다.
        node[find(c)] = find(b)
    }

    // m번의 연산을 반복 수행합니다.
    repeat(m) {
        // 연산의 종류(a), 두 노드 번호(b, c)를 입력으로 받습니다.
        val (a, b, c) = readLine()!!.split(' ').map { it.toInt() }
        when(a) {
            0 -> union(b, c) // 0일 경우, 두 노드를 합칩니다.
            1 -> println(if (find(b) == find(c)) "YES" else "NO") // 1일 경우, 두 노드가 같은 집합에 속하는지 확인합니다.
        }
    }
}
