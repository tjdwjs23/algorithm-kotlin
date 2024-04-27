/**
 * 요세푸스 문제는 다음과 같다.
 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
 */

fun main() = System.`in`.bufferedReader().run {
    // 첫 줄을 읽어서 n과 k 값을 정수로 변환합니다.
    val (n, k) = readLine().split(" ").map { it.toInt() }
    // 1부터 n까지의 숫자를 포함하는 ArrayDeque를 생성합니다. 이는 요세푸스 문제에서의 사람들을 나타냅니다.
    val queue = (1..n).toCollection(ArrayDeque())

    // 제거된 사람들을 저장할 결과 리스트를 초기화합니다.
    val result = mutableListOf<Int>()
    
    // 큐가 빌 때까지 반복합니다.
    while (queue.isNotEmpty()) {
        // k-1번째 요소까지 큐의 첫 번째 요소를 마지막으로 이동시킵니다.
        // 이는 k번째 사람을 제거하기 위한 준비 단계입니다.
        for (i in 1 until k) {
            queue.addLast(queue.removeFirst())
        }
        // k번째 사람(현재 큐의 첫 번째 요소)을 제거하고 결과 리스트에 추가합니다.
        result.add(queue.removeFirst())
    }
    
    // 결과 리스트를 문자열로 변환하여 출력합니다. 
    // joinToString 함수를 사용하여 각 요소를 ", "로 구분하고 "<"와 ">"로 감싸서 출력합니다.
    println("<${result.joinToString(", ")}>")
}
