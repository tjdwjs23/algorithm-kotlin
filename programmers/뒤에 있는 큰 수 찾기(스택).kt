/**
 * 정수로 이루어진 배열 numbers가 있습니다. 배열 의 각 원소들에 대해 자신보다 뒤에 있는 숫자 중에서 자신보다 크면서 가장 가까이 있는 수를 뒷 큰수라고 합니다.
 * 정수 배열 numbers가 매개변수로 주어질 때, 모든 원소에 대한 뒷 큰수들을 차례로 담은 배열을 return 하도록 solution 함수를 완성해주세요. 단, 뒷 큰수가 존재하지 않는 원소는 -1을 담습니다.
 */

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val stack = ArrayDeque<Int>()
        // 결과를 저장할 배열 초기화
        val result = IntArray(numbers.size) { -1 }

        // 주어진 배열을 순회하면서 로직 수행
        numbers.forEachIndexed { index, value ->
            // 스택이 비어있지 않고, 현재 값이 스택의 마지막 값보다 크다면
            while (stack.isNotEmpty() && numbers[stack.last()] < value) {
                // 결과 배열에 현재 값을 저장
                result[stack.removeLast()] = value
            }
            // 현재 인덱스를 스택에 추가
            stack.add(index)
        }

        // 최종 결과 반환
        return result
    }
}
