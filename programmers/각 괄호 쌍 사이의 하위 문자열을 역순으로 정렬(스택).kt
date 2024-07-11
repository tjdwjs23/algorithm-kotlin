/**
 * Reverse Substrings Between Each Pair of Parentheses
 *
 * Hint
 * You are given a string s that consists of lower case English letters and brackets.
 *
 * Reverse the strings in each pair of matching parentheses, starting from the innermost one.
 *
 * Your result should not contain any brackets.
 */

class Solution {
    fun reverseParentheses(s: String): String {
        val stack = ArrayDeque<String>()
        var str = ""
        for (c in s) {
            when (c) {
                // '('를 만나면 stack에 현재까지의 문자열을 추가하고 str을 초기화합니다.
                '(' -> {
                    stack.add(str)
                    str = ""
                }
                // ')'를 만나면 stack에서 문자열을 꺼내서 뒤집어준 뒤 str에 추가합니다.
                ')' -> {
                    str = stack.removeLast() + str.reversed()
                }
                // 괄호가 아닌 문자열은 str에 추가합니다.
                else -> {
                    str += c
                }
            }
        }
        return str
    }
}
