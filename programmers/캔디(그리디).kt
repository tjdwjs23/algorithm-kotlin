/**
 * n아이들이 줄을 서 있어요 . 각 어린이에게는 정수 배열에 지정된 등급 값이 할당됩니다 ratings.
 *
 * 당신은 다음 요구 사항을 충족하는 어린이에게 사탕을 제공합니다.
 *
 * 각 어린이는 적어도 하나의 사탕을 가지고 있어야 합니다.
 * 높은 평가를 받은 어린이는 이웃보다 더 많은 사탕을 받습니다.
 * 아이들에게 사탕을 나눠주는 데 필요한 최소 사탕 수를 반환합니다 .
 */

class Solution {
    fun candy(ratings: IntArray): Int {
        val n = ratings.size
        val candies = IntArray(n) { 1 }

        // 앞에서부터 스캔하며 조건에 맞는 사탕 수 조정
        for (i in 1 until n) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1
        }

        // 뒤에서부터 스캔하며 조정
        for (i in n - 2 downTo 0) {
            // 더 큰 값을 유지하도록 조정
            if (ratings[i] > ratings[i + 1]) candies[i] = maxOf(candies[i], candies[i + 1] + 1)
        }

        // 모든 사탕 수의 합을 계산
        return candies.sum()
    }

}