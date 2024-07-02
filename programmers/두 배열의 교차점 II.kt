/**
 * 두 배열의 교차점 II
 * 두 개의 정수 배열과 가 주어지면 nums1, 그 교집합의 배열을nums2 반환합니다 . 결과의 각 요소는 두 배열에 표시된 횟수만큼 나타나야 하며, 결과를 어떤 순서 로든 반환할 수 있습니다 .
 */

class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val result = mutableListOf<Int>()
        val map = HashMap<Int, Int>()

        // nums1의 각 요소를 카운트하여 map에 저장합니다.
        nums1.forEach{ num ->
            map[num] = map.getOrDefault(num, 0) + 1
        }
        
        // nums2의 각 요소를 확인하며 map에 저장된 값이 0보다 크면 결과에 추가하고 카운트를 줄입니다.
        nums2.forEach{ num ->
            map[num]?.let{ value ->
                if(value > 0){
                    result.add(num)
                    map[num] = value - 1
                }
            }
        }
        return result.toIntArray()
    }
}
