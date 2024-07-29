/**
 * 팀의 수를 세어보세요
 *
 * n군인들이 줄을 서서 서 있습니다 . 각 군인에게 고유한 rating 값이 할당됩니다.
 *
 * 다음 규칙에 따라 3명의 군인으로 팀을 구성해야 합니다.
 *
 * i지수( , j, k)와 등급( rating[i], rating[j], rating[k]) 을 가진 군인 3명을 선택하세요 .
 * 팀은 다음의 경우 유효합니다: ( rating[i] < rating[j] < rating[k]) 또는 ( rating[i] > rating[j] > rating[k])인 경우 ( 0 <= i < j < k < n).
 * 주어진 조건에 따라 구성할 수 있는 팀의 수를 반환합니다. (군인은 여러 팀에 속할 수 있습니다.)
 */

class Solution {
    fun numTeams(rating: IntArray): Int {
        var count = 0
        // rating 배열의 모든 요소에 대해 반복합니다.
        for (i in rating.indices) {
            var leftLess = 0
            var leftGreater = 0
            var rightLess = 0
            var rightGreater = 0
            // i번째 군인을 기준으로 왼쪽에 있는 군인들과 오른쪽에 있는 군인들을 비교합니다.
            for (j in 0 until i) {
                if (rating[j] < rating[i]) leftLess++
                if (rating[j] > rating[i]) leftGreater++
            }
            // i번째 군인을 기준으로 오른쪽에 있는 군인들을 비교합니다.
            for (j in i + 1 until rating.size) {
                if (rating[j] < rating[i]) rightLess++
                if (rating[j] > rating[i]) rightGreater++
            }
            // i번째 군인을 기준으로 가능한 모든 팀의 수를 계산합니다.
            count += leftLess * rightGreater + leftGreater * rightLess
        }
        return count

    }
}
