/**
 * 색상 정렬
 * 빨간색, 흰색 또는 파란색으로 색상이 지정된 개체 nums가 있는 배열이 주어지면 동일한 색상의 개체가 빨간색, 흰색, 파란색 순서로 인접하도록 해당 위치에서 정렬합니다.n
 *
 * 정수 0, 1, 를 사용하여 2각각 빨간색, 흰색, 파란색을 나타냅니다.
 *
 * 라이브러리의 정렬 기능을 사용하지 않고 이 문제를 해결해야 합니다.
 */

class Solution {
    fun sortColors(nums: IntArray): Unit {
        // 색상의 개수를 저장할 배열을 초기화합니다.
        val counts = IntArray(3)

        // 각 색상의 개수를 세어줍니다.
        nums.forEach{
            counts[it] += 1
        }
        // 개수를 기반으로 배열을 업데이트합니다.
        var i = 0
        // 빨간색, 흰색, 파란색 순서로 정렬합니다.
        for(color in 0 until counts.size){
            while(counts[color]>0){
                nums[i++] = color
                counts[color] -= 1
            }
        }
    }
}
