/**
 * Maximum Score From Removing Substrings
 * Hint
 * You are given a string s and two integers x and y. You can perform two types of operations any number of times.
 *
 * Remove substring "ab" and gain x points.
 * For example, when removing "ab" from "cabxbae" it becomes "cxbae".
 * Remove substring "ba" and gain y points.
 * For example, when removing "ba" from "cabxbae" it becomes "cabxe".
 * Return the maximum points you can gain after applying the above operations on s.
 */

class Solution {
    fun maximumGain(s: String, x: Int, y: Int): Int {
        // a, b를 정하고, x, y를 정합니다.
        val (a, b) = if (x > y) 'a' to 'b' else 'b' to 'a'
        // m, n을 정합니다.
        val (m, n) = if (x > y) x to y else y to x
        val stack = ArrayDeque<Char>()
        var score = 0
        // s를 순회하면서, stack에 문자를 추가하고, stack의 마지막 문자가 a이고, 현재 문자가 b이면, stack에서 마지막 문자를 제거하고, score에 m을 추가합니다.
        for (c in s) {
            if (c == b && stack.isNotEmpty() && stack.last() == a) {
                stack.removeAt(stack.lastIndex)
                score += m
            } else {
                stack.add(c)
            }
        }
        // 새로운 stack을 만들고, stack을 순회하면서, stack의 문자가 a이고, 새로운 stack의 마지막 문자가 b이면, 새로운 stack에서 마지막 문자를 제거하고, score에 n을 추가합니다.
        val newStack = ArrayDeque<Char>()
        for (c in stack) {
            if (c == a && newStack.isNotEmpty() && newStack.last() == b) {
                newStack.removeAt(newStack.lastIndex)
                score += n
            } else {
                newStack.add(c)
            }
        }
        return score

    }
}
