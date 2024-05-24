/**
 * 문제 설명
 * 자연수 x를 y로 변환하려고 합니다. 사용할 수 있는 연산은 다음과 같습니다.
 *
 * x에 n을 더합니다
 * x에 2를 곱합니다.
 * x에 3을 곱합니다.
 * 자연수 x, y, n이 매개변수로 주어질 때, x를 y로 변환하기 위해 필요한 최소 연산 횟수를 return하도록 solution 함수를 완성해주세요. 이때 x를 y로 만들 수 없다면 -1을 return 해주세요.
 */

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        val visited = mutableSetOf<Int>()
        val queue = ArrayDeque<Int>()
        var operationCount = 0
        queue.addLast(x)
        while (queue.isNotEmpty()) {
            // 현재 큐에 있는 모든 수에 대해 연산을 수행
            for (i in 0 until queue.size) {
                val current = queue.removeFirst()
                // y에 도달하면 연산 횟수를 반환
                if (current == y) {
                    return operationCount
                }
                // y보다 크거나 이미 방문한 수는 무시
                if (current > y || current in visited) {
                    continue
                }
                // 방문 처리 후 큐에 연산 결과 추가
                visited.add(current)
                queue.addLast(current + n)
                queue.addLast(current * 2)
                queue.addLast(current * 3)
            }
            // 연산 횟수 증가
            operationCount++
        }
        return -1
    }
}
