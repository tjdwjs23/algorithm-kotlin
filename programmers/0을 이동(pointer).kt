/**
 * 정수 배열이 주어지면 0이 아닌 요소의 상대적 순서를 유지하면서 모든 을 배열의 끝으로 nums이동합니다 .
 *
 * 배열의 복사본을 만들지 않고 이 작업을 내부에서 수행해야 합니다 .
 */

fun moveZeroes(nums: IntArray): Unit {
    // nonZeroIndex는 배열에서 0이 아닌 요소들이 들어갈 위치를 추적합니다.
    var nonZeroIndex = 0

    // 첫 번째 for 루프: 배열의 모든 요소를 순회합니다.
    for (i in nums.indices) {
        // 현재 요소(nums[i])가 0이 아니면, 해당 요소를 nonZeroIndex 위치에 놓습니다.
        if (nums[i] != 0) {
            nums[nonZeroIndex++] = nums[i] // 그리고 nonZeroIndex를 1 증가시킵니다.
        }
    }

    // 위의 루프를 통해 모든 0이 아닌 요소들이 배열의 앞부분으로 이동하고,
    // nonZeroIndex는 첫 번째 0이 위치해야 할 인덱스를 가리키게 됩니다.

    // 두 번째 for 루프: nonZeroIndex부터 배열의 끝까지 순회합니다.
    for (i in nonZeroIndex until nums.size) {
        // 이 영역에는 모두 0을 채워 넣습니다.
        // 이는 모든 0이 아닌 값들이 이미 배열의 앞부분으로 이동했기 때문에,
        // 남은 부분에는 0만 채울 수 있습니다.
        nums[i] = 0
    }
    // 이 함수는 주어진 배열 내에서 직접 조작을 통해,
    // 모든 0을 배열의 끝으로 이동시키고, 나머지 0이 아닌 요소들은
    // 원래 순서를 유지하면서 배열의 앞부분으로 이동시킵니다.
}
