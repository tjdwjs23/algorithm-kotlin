/**
 * 점프게임2
 * 정수 배열 nums가 주어지면, nums[i]는 i번째 위치에서 점프할 수 있는 최대 길이를 나타냅니다.
 * 당신은 첫 번째 위치에서 시작하여 마지막 위치로 도달하기 위해 필요한 최소 점프 수를 반환해야 합니다.
 */




class Solution {
    fun jump(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return 0

        var jumps = 0
        var currentEnd = 0
        var farthest = 0

        // 마지막 인덱스에 도달하기 전까지 반복합니다.
        for (i in 0 until n - 1) {
            // 현재 위치에서 점프하여 갈 수 있는 최대 거리를 갱신합니다.
            farthest = maxOf(farthest, i + nums[i])
            // 현재 위치가 현재까지 갈 수 있는 최대 거리와 같다면, 점프를 하나 더 해야 합니다.
            if (i == currentEnd) {
                jumps++
                currentEnd = farthest
                // 만약 마지막 인덱스에 도달했다면, 반복문을 종료합니다.
                if (currentEnd >= n - 1) break
            }
        }

        return jumps
    }
}
