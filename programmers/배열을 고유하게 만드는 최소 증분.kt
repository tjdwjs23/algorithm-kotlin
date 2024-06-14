/**
 * 배열을 고유하게 만드는 최소 증분
 * 정수 배열이 제공됩니다 nums. 한 번의 이동으로 인덱스를 선택 하고 씩 증가시킬 i수 있습니다 .0 <= i < nums.lengthnums[i]1
 *
 * 모든 값을 고유 하게 만들기 위한 최소 이동 횟수를 반환합니다 .nums
 *
 * 테스트 케이스는 답변이 32비트 정수에 맞도록 생성됩니다.
 */

class Solution {
    fun minIncrementForUnique(nums: IntArray): Int {
        nums.sort()
        var moves = 0
        // 배열을 순회하면서
        for (i in 1 until nums.size) {
            // 이전 값보다 작거나 같은 경우, 이전 값보다 1 크게 만들어줍니다.
            if (nums[i] <= nums[i - 1]) {
                // 이동 횟수를 더하고, 현재 값을 이전 값보다 1 크게 만듭니다.
                moves += nums[i - 1] - nums[i] + 1
                // 현재 값을 이전 값보다 1 크게 만듭니다.
                nums[i] = nums[i - 1] + 1
            }
        }
        return moves
    }
}
