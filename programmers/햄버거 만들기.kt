/**
 * 햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다.
 * 함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다.
 * 상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
 * 예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
 * 상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
 */

class Solution {
    fun solution(ingredient: IntArray): Int {
        val stack = ArrayDeque<Int>()
        // 포장된 햄버거의 개수를 셀 변수
        var burgerCount = 0

        // 주어진 재료를 순회하면서 각 재료를 처리
        ingredient.forEach { ingredient ->
            // 현재 재료를 스택에 추가
            stack.addLast(ingredient)
            // 스택에서 햄버거를 확인하고 제거할 수 있는 경우, 햄버거 개수 증가
            if (stack.checkAndRemoveBurger()) {
                burgerCount++
            }
        }

        // 최종적으로 포장된 햄버거의 개수 반환
        return burgerCount
    }

    // 햄버거를 확인하고 제거하는 로직
    private fun ArrayDeque<Int>.checkAndRemoveBurger(): Boolean {
        // 스택의 크기가 4 이상이면서 마지막 4개의 재료가 햄버거를 구성하는 경우
        if (this.size >= 4 && this.takeLast(4) == listOf(1, 2, 3, 1)) {
            // 마지막 4개의 재료를 스택에서 제거
            repeat(4) { this.removeLast() }
            // 햄버거를 성공적으로 확인하고 제거했으므로 true 반환
            return true
        }
        // 위 조건을 만족하지 않는 경우, false 반환
        return false
    }
}
