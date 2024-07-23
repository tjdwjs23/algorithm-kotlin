/**
 * Sort Array by Increasing Frequency
 *
 * Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.
 *
 * Return the sorted array.
 */

class Solution {
    fun frequencySort(nums: IntArray) =
        nums.sortedDescending().sortedBy {i -> nums.count { it == i}}
}
