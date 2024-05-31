/**
 * 260. 단일 번호 III
 * 
 * nums정확히 두 개의 요소가 한 번만 나타나고 다른 모든 요소는 정확히 두 번 나타나는 정수 배열이 제공됩니다 . 한 번만 나타나는 두 요소를 찾으십시오. 어떤 순서 로든 답변을 반환할 수 있습니다 .
 *
 * 선형 런타임 복잡성으로 실행되고 일정한 추가 공간만 사용하는 알고리즘을 작성해야 합니다.
 *
 */

class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        // 모든 숫자를 XOR하여 두 개의 고유한 숫자의 XOR 결과를 얻음
        var bitmask = 0
        for (num in nums) bitmask = bitmask xor num

        // 두 숫자가 다르게 되는 첫 번째 비트를 찾음
        // 이 비트는 두 숫자가 서로 다르다는 것을 나타냄
        val diff = bitmask and (-bitmask)

        // 첫 번째 고유한 숫자를 찾음
        // diff 비트가 1인 숫자들을 XOR하여 첫 번째 고유한 숫자를 찾음
        var x = 0
        for (num in nums)
            if ((num and diff) != 0)
                x = x xor num

        // 첫 번째 고유한 숫자 x와 bitmask를 XOR하여 두 번째 고유한 숫자를 찾음
        return intArrayOf(x, bitmask xor x)
    }
}
