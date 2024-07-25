/**
 * Sort an Array
 *
 * Companies
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 */

class Solution {
    fun IntArray.quickSort(): IntArray {
        fun partition(low: Int, high: Int): Int {
            // 피벗 선택 (중간값)
            val pivot = this[(low + high) / 2]
            var i = low
            var j = high
            // 피벗을 기준으로 좌우로 나누기
            while (true) {
                // 피벗보다 작은 값이 나올 때까지 i를 증가
                while (this[i] < pivot) i++
                // 피벗보다 큰 값이 나올 때까지 j를 감소
                while (this[j] > pivot) j--
                // i가 j보다 크거나 같으면 종료
                if (i >= j) return j
                // i번째 값과 j번째 값을 교환
                this[i] = this[j].also { this[j] = this[i] }
                i++
                j--
            }
        }

        // 퀵 정렬
        fun sort(low: Int, high: Int) {
            // low가 high보다 작을 때까지
            if (low < high) {
                val p = partition(low, high)
                sort(low, p)
                sort(p + 1, high)
            }
        }
        sort(0, lastIndex)
        return this
    }

    fun sortArray(nums: IntArray): IntArray {
        return nums.quickSort()
    }
}
