/**
 *  Longest Palindrome
 *
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest
 * palindrome
 *  that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 */

class Solution {
    fun longestPalindrome(s: String): Int {
        // 문자열 s의 각 문자의 개수를 저장할 배열 생성
        // ASCII 코드 범위 내의 문자들을 모두 포함할 수 있도록 크기를 128로 설정
        val charCount = IntArray(128)

        // 가장 긴 팰린드롬 문자열의 길이를 저장할 변수 초기화
        var length = 0

        // 문자열 s의 각 문자의 개수를 charCount 배열에 저장
        for(i in s){
            charCount[i.toInt()]++
        }

        // charCount 배열의 각 원소(문자의 개수)를 확인하며 가장 긴 팰린드롬 문자열의 길이 계산
        for (i in charCount) {
            // 각 문자의 개수를 2로 나눈 몫 * 2를 더하여 짝수 길이의 팰린드롬 부분 길이 계산
            length += i / 2 * 2
            // 만약 현재까지의 길이가 짝수이고 현재 문자의 개수가 홀수라면, 가장 가운데 있는 문자를 포함시키기 위해 길이를 1 증가
            if (length % 2 == 0 && i % 2 == 1) {
                length++
            }
        }

        // 가장 긴 팰린드롬 문자열의 길이 반환
        return length
    }
}
