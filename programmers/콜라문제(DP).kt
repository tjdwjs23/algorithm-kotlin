/**
 * 콜라를 받기 위해 마트에 주어야 하는 병 수 a, 빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b, 상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다. 상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.
 */


class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var bottle = n
        var count = 0
        // 빈 병이 a개 이상일 때까지 반복
        while(bottle >= a) {
            // 빈 병을 a개로 나눈 몫을 구하고, 그 몫에 b를 곱하여 콜라를 받습니다.
            val exchange = bottle / a
            count += exchange * b
            // 콜라를 받은 후 남은 빈 병의 개수는 나머지로 구합니다.
            bottle = exchange * b + bottle % a
        }
        return count
    }
}
