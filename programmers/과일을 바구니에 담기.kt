/**
 * fruits두 개의 정수 배열, , 가 주어집니다. baskets각 배열의 길이는 다음과 같습니다 n. 여기서 는 과일 종류 의 수량을fruits[i] 나타내고 는 바구니 의 용량을 나타냅니다 .ithbaskets[j]jth
 *
 * 왼쪽에서 오른쪽으로, 다음 규칙에 따라 과일을 배치하세요.
 *
 * 각 과일 종류는 해당 과일 종류의 수량 보다 크거나 같은 용량을 가진 가장 왼쪽의 바구니 에 담아야 합니다 .
 * 각 바구니에는 한 종류의 과일만 담을 수 있습니다.
 * 어떤 바구니에도 놓을 수 없는 과일 종류는 놓이지 않은 채로 남습니다 .
 * 가능한 모든 할당이 이루어진 후 배치되지 않은 과일 유형의 수를 반환합니다.
 *
 * 예시 1:
 *
 * 입력: 과일 = [4,2,5], 바구니 = [3,5,4]
 *
 * 출력: 1
 *
 * 설명:
 *
 * fruits[0] = 4에 배치됩니다 baskets[1] = 5.
 * fruits[1] = 2에 배치됩니다 baskets[0] = 3.
 * fruits[2] = 5에 배치할 수 없습니다 baskets[2] = 4.
 * 한 가지 과일 유형이 배치되지 않았으므로 1을 반환합니다.
 *
 * 예 2:
 *
 * 입력: 과일 = [3,6,1], 바구니 = [6,4,7]
 *
 * 출력: 0
 *
 * 설명:
 *
 * fruits[0] = 3에 배치됩니다 baskets[0] = 6.
 * fruits[1] = 6(수용량 부족) 에는 넣을 수 없지만 baskets[1] = 4, 다음 가능한 바구니에는 넣을 수 있습니다 baskets[2] = 7.
 * fruits[2] = 1에 배치됩니다 baskets[1] = 4.
 * 모든 과일이 성공적으로 배치되었으므로 0을 반환합니다.
 *
 */
class Solution {
    fun numOfUnplacedFruits(fruits: IntArray, baskets: IntArray): Int {
        var unplacedCount = fruits.size

        for (fruitCount in fruits) {
            for (j in 0..fruits.size-1) {
                if (fruitCount <= baskets[j]) {
                    baskets[j] = 0
                    unplacedCount--
                    break
                }
            }
        }

        return unplacedCount
    }
}
