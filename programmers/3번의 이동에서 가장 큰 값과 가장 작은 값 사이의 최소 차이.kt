/**
 * 3번의 이동에서 가장 큰 값과 가장 작은 값 사이의 최소 차이
 *
 * 힌트
 * 정수 배열이 주어집니다 nums.
 *
 * 한 번의 이동으로 하나의 요소를 선택하여 원하는 값nums 으로 변경할 수 있습니다 .
 *
 * 최대 3번의 이동을 수행한 후 가장 큰 값과 가장 작은 값의 최소 차이를nums 반환합니다 .
 *
 */

class Solution {
    fun minDifference(nums: IntArray): Int {
        // 배열의 길이가 4 이하인 경우, 모든 요소를 합칠 수 있으므로 최소 차이는 0이 됩니다.
        if (nums.size <= 4) return 0

        // 배열을 오름차순으로 정렬합니다.
        nums.sort()

        // 최소 차이를 저장할 변수를 초기화합니다.
        var min = Int.MAX_VALUE

        // 배열의 마지막 4개 요소와 처음 4개 요소의 차이를 계산하고,
        // 이 차이들 중 최소값을 찾습니다.
        for (i in 0..3) {
            min = minOf(min, nums[nums.size - 4 + i] - nums[i])
        }

        // 최소 차이를 반환합니다.
        return min
    }
}
