/**
 * Sort the People
 * Easy
 * Topics
 * Companies
 * Hint
 * You are given an array of strings names, and an array heights that consists of distinct positive integers. Both arrays are of length n.
 *
 * For each index i, names[i] and heights[i] denote the name and height of the ith person.
 *
 * Return names sorted in descending order by the people's heights.
 */

class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        // names와 heights를 매핑합니다.
        // TreeMap을 사용하면 키를 기준으로 정렬할 수 있습니다.
        val namesMap = TreeMap<Int,String>()
        // heights를 기준으로 내림차순으로 정렬합니다.
        heights.forEachIndexed { index, height ->
            namesMap.put(height,names[index])
        }
        // 정렬된 names를 반환합니다.
        return namesMap.values.reversed().toTypedArray()
    }
}

class Solution {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        // names와 heights를 매핑합니다.
        val namesMap = HashMap<Int, String>()
        // heights를 기준으로 내림차순으로 정렬합니다.
        heights.forEachIndexed { index, height ->
            namesMap[height] = names[index]
        }
        // TreeMap과 달리 HashMap은 정렬이 되지 않으므로 정렬을 수행한 후 반환합니다.
        return namesMap.toList().sortedByDescending { it.first }.map { it.second }.toTypedArray()
    }
}
