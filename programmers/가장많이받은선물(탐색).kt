/**
 * 선물을 직접 전하기 힘들 때 카카오톡 선물하기 기능을 이용해 축하 선물을 보낼 수 있습니다. 당신의 친구들이 이번 달까지 선물을 주고받은 기록을 바탕으로 다음 달에 누가 선물을 많이 받을지 예측하려고 합니다.

 * 두 사람이 선물을 주고받은 기록이 있다면, 이번 달까지 두 사람 사이에 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
 * 예를 들어 A가 B에게 선물을 5번 줬고, B가 A에게 선물을 3번 줬다면 다음 달엔 A가 B에게 선물을 하나 받습니다.
 * 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면, 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
 * 선물 지수는 이번 달까지 자신이 친구들에게 준 선물의 수에서 받은 선물의 수를 뺀 값입니다.
 * 예를 들어 A가 친구들에게 준 선물이 3개고 받은 선물이 10개라면 A의 선물 지수는 -7입니다. B가 친구들에게 준 선물이 3개고 받은 선물이 2개라면 B의 선물 지수는 1입니다. 만약 A와 B가 선물을 주고받은 적이 없거나 정확히 같은 수로 선물을 주고받았다면, 다음 달엔 B가 A에게 선물을 하나 받습니다.
 * 만약 두 사람의 선물 지수도 같다면 다음 달에 선물을 주고받지 않습니다.
 * 위에서 설명한 규칙대로 다음 달에 선물을 주고받을 때, 당신은 선물을 가장 많이 받을 친구가 받을 선물의 수를 알고 싶습니다.

 * 친구들의 이름을 담은 1차원 문자열 배열 friends 이번 달까지 친구들이 주고받은 선물 기록을 담은 1차원 문자열 배열 gifts가 매개변수로 주어집니다. 이때, 다음달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 return 하도록 solution 함수를 완성해 주세요.
 */

class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        // 친구들의 총 수를 저장
        val friendsLength = friends.size
        // 친구의 이름을 키로, 그 친구의 인덱스를 값으로 하는 맵 생성
        val friendIndexMap = mutableMapOf<String, Int>()
        // 각 친구가 받은 선물의 순수 개수(보낸 선물 수 - 받은 선물 수)를 저장하는 배열
        val giftDegree = IntArray(friendsLength) { 0 }
        // 선물을 주고받은 관계를 나타내는 그래프. giftGraph[i][j]는 i번째 친구가 j번째 친구에게 준 선물의 수를 나타냄
        val giftGraph = Array(friendsLength) { IntArray(friendsLength) { 0 } }

        // 각 친구의 이름과 인덱스를 맵에 저장
        friends.forEachIndexed { index, friend ->
            friendIndexMap[friend] = index
        }

        // 선물 목록을 순회하며, 선물을 보낸 사람과 받은 사람의 인덱스를 확인한 후 해당 정보를 기반으로 데이터 업데이트
        gifts.forEach { gift ->
            val (sender, receiver) = gift.split(" ")
            val senderIndex = friendIndexMap[sender] ?: return@forEach
            val receiverIndex = friendIndexMap[receiver] ?: return@forEach

            // 선물을 보낸 사람의 giftDegree를 증가시키고, 받은 사람의 giftDegree를 감소
            giftDegree[senderIndex]++
            giftDegree[receiverIndex]--
            // 선물 그래프 업데이트
            giftGraph[senderIndex][receiverIndex]++
        }

        // 각 친구가 다른 친구들과 비교했을 때, 더 많은 선물을 주거나, 동일한 수의 선물을 주었으나 자신이 더 많이 받은 경우의 수를 세어 최댓값 갱신
        var maxGifts = 0
        for (i in friends.indices) {
            var count = 0
            for (j in friends.indices) {
                if (i != j && (giftGraph[i][j] > giftGraph[j][i] ||
                        (giftGraph[i][j] == giftGraph[j][i] && giftDegree[i] > giftDegree[j]))) {
                    count++
                }
            }
            maxGifts = maxOf(maxGifts, count)
        }
        return maxGifts
    }
}
