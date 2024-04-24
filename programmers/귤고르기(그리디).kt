/**
 * 경화는 과수원에서 귤을 수확했습니다. 경화는 수확한 귤 중 'k'개를 골라 상자 하나에 담아 판매하려고 합니다. 그런데 수확한 귤의 크기가 일정하지 않아 보기에 좋지 않다고 생각한 경화는 귤을 크기별로 분류했을 때 서로 다른 종류의 수를 최소화하고 싶습니다.
 *
 * 예를 들어, 경화가 수확한 귤 8개의 크기가 [1, 3, 2, 5, 4, 5, 2, 3] 이라고 합시다. 경화가 귤 6개를 판매하고 싶다면, 크기가 1, 4인 귤을 제외한 여섯 개의 귤을 상자에 담으면, 귤의 크기의 종류가 2, 3, 5로 총 3가지가 되며 이때가 서로 다른 종류가 최소일 때입니다.
 *
 * 경화가 한 상자에 담으려는 귤의 개수 k와 귤의 크기를 담은 배열 tangerine이 매개변수로 주어집니다. 경화가 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값을 return 하도록 solution 함수를 작성해주세요.
 */

class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        // 'tangerine' 배열의 각 요소를 카운트하여 내림차순으로 정렬된 배열 'sortedCounts'를 생성합니다.
        val sortedCounts = tangerine.toTypedArray()
            .groupingBy { it }.eachCount().values
            .toIntArray().sortedDescending()

        var selectedCount = 0 // 선택된 요소의 수를 카운트할 변수 'selectedCount'를 선언하고 0으로 초기화합니다.

        // 'sortedCounts' 배열을 순회하며, 'selectedCount'가 'k' 이상이 되는 최초의 위치를 찾아 인덱스를 반환합니다.
        return sortedCounts.indexOfFirst { count ->
            selectedCount += count // 'count'를 'selectedCount'에 더합니다.
            selectedCount >= k // 'selectedCount'가 'k' 이상이면 true를 반환하여 순회를 중단합니다.
        } + 1 // 인덱스는 0부터 시작하므로, 실제 고유한 요소 개수를 반환하기 위해 1을 더합니다.
    }
}
