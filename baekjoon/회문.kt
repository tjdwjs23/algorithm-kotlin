/**
 * 회문(回文) 또는 팰린드롬(palindrome)은 앞 뒤 방향으로 볼 때 같은 순서의 문자로 구성된 문자열을 말한다.
 * 예를 들어 ‘abba’ ‘kayak’, ‘reviver’, ‘madam’은 모두 회문이다.
 * 만일 그 자체는 회문이 아니지만 한 문자를 삭제하여 회문으로 만들 수 있는 문자열이라면 우리는 이런 문자열을 “유사회문”(pseudo palindrome)이라고 부른다.
 * 예를 들어 ‘summuus’는 5번째나 혹은 6번째 문자 ‘u’를 제거하여 ‘summus’인 회문이 되므로 유사회문이다.
 * 여러분은 제시된 문자열을 분석하여 그것이 그 자체로 회문인지, 또는 한 문자를 삭제하면 회문이 되는 “유사회문”인지,
 * 아니면 회문이나 유사회문도 아닌 일반 문자열인지를 판단해야 한다. 만일 문자열 그 자체로 회문이면 0, 유사회문이면 1, 그 외는 2를 출력해야 한다.
 */

fun main() = System.`in`.bufferedReader().run {
    // 첫 번째 줄에서 입력받은 숫자만큼 반복합니다.
    repeat(readLine().toInt()) {
        // 각 반복마다 한 줄씩 읽어서 isPalindrome 함수의 결과를 출력합니다.
        println(readLine().isPalindrome())
    }
}

// 확장 함수를 사용하여 String 클래스에 isPalindrome 함수를 추가합니다.
// 이 함수는 주어진 문자열이 회문인지, 또는 회문이 되기 위해 삭제해야 하는 최소 문자 수를 반환합니다.
fun String.isPalindrome(left: Int = 0, right: Int = this.length - 1, corrections: Int = 0): Int {
    // 만약 corrections가 2라면, 이미 2개 이상의 문자를 삭제해야 하므로 회문을 만들 수 없습니다.
    if (corrections == 2) return corrections
    // 만약 left 인덱스가 right 인덱스보다 크거나 같다면, 모든 문자를 검사했으므로 corrections를 반환합니다.
    if (left >= right) return corrections

    // 현재 left와 right 인덱스의 문자가 같다면, 다음 문자를 검사하기 위해 재귀 호출합니다.
    return if (this[left] == this[right]) {
        isPalindrome(left + 1, right - 1, corrections)
    } else {
        // 만약 문자가 다르다면, 두 가지 경우를 고려합니다:
        // 1. 왼쪽 문자를 제거하고 재귀 호출합니다.
        val removeLeft = isPalindrome(left + 1, right, corrections + 1)
        // 2. 오른쪽 문자를 제거하고 재귀 호출합니다.
        val removeRight = isPalindrome(left, right - 1, corrections + 1)
        // 두 경우 중 더 적은 수정으로 회문을 만들 수 있는 경우를 선택합니다.
        if (removeLeft < removeRight) removeLeft else removeRight
    }
}
