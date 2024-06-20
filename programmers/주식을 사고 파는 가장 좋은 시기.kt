/**
 * 주식을 사고 팔기에 가장 좋은 시기
 * 해당 날짜 의 특정 주식 가격을 나타내는 prices배열 이 제공됩니다 .prices[i]ith
 *
 * 특정 주식을 구매할 하루를 선택하고 해당 주식을 판매할 미래의 다른 날을 선택 하여 수익을 극대화하려고 합니다 .
 *
 * 이 거래에서 얻을 수 있는 최대 이익을 반환합니다 . 이익을 얻을 수 없으면 를 반환하십시오
 */

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        // 최소 가격과 최대 이익을 계산합니다.
        prices.forEach { price ->
            // 현재 가격이 최소 가격보다 작다면, 최소 가격을 업데이트합니다.
            if (price < minPrice) {
                minPrice = price
            }
            // 현재 가격에서 최소 가격을 뺀 이익을 계산합니다.
            val potentialProfit = price - minPrice
            // 이익이 최대 이익보다 크다면, 최대 이익을 업데이트합니다.
            if (potentialProfit > maxProfit) {
                maxProfit = potentialProfit
            }
        }

        return maxProfit
    }
}
