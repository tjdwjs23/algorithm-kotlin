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
        // bitmask을 이용한 풀이
        var bitmask = 0
        // bitmask에는 두 개의 single number를 xor한 결과가 저장됩니다.
        for (num in nums) bitmask = bitmask xor num

        // bitmask의 가장 오른쪽에 있는 1을 찾습니다.
        val diff = bitmask and (-bitmask)

        var x = 0
        // bitmask을 기준으로 두 개의 single number를 구분합니다.
        for (num in nums)
            // bitmask과 diff를 이용해 두 개의 single number를 구분합니다.
            if ((num and diff) != 0)
                x = x xor num
        // x와 bitmask을 xor하면 나머지 single number를 구할 수 있습니다.
        return intArrayOf(x, bitmask xor x)
    }
}
