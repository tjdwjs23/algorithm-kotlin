/**
* 멋진 문자열 은 최대 하나의 문자가 홀수 번 나타나는 문자열입니다 .
* 
* 예를 들어, "ccjjc"and "abab"는 훌륭하지만 "ab"그렇지 않습니다.
* word처음 10개의 영어 소문자( 'a'~ 'j') 로 구성된 문자열이 주어지면 에서 비어 있지 않은 멋진 하위 문자열의 수를 반환 합니다 word. 동일한 하위 문자열이 에 여러 번 나타나는 경우 각 발생을word 개별적으로 계산합니다 .
* 
* 하위 문자열은 문자열 에서 연속된 문자 시퀀스입니다.
*/

class Solution {
    fun wonderfulSubstrings(word: String): Long {
        // 각 문자열 상태를 나타내는 비트마스크에 대한 개수를 저장하는 배열입니다. 
        // 1024는 2^10으로, 알파벳 소문자가 10개까지만 있다고 가정한 상태입니다.
        val count = IntArray(1024)
        var res: Long = 0 // 결과 값을 저장할 변수입니다.
        var currentMask = 0 // 현재까지 문자열의 상태를 나타내는 비트마스크입니다.
        count[0] = 1 // 비어있는 문자열 상태를 나타냅니다.
        
        // 입력된 단어의 각 문자에 대해 반복합니다.
        for (i in 0 until word.length) {
            // 현재 문자를 나타내는 비트를 XOR 연산을 통해 토글합니다.
            // 이는 현재 문자의 홀짝 상태를 변경합니다.
            currentMask = currentMask xor (1 shl (word[i].code - 'a'.code))
            
            // 현재 상태가 기존에 존재했다면, 그 개수만큼 결과값에 더합니다.
            // 이는 현재 상태를 만들 수 있는 모든 부분 문자열을 포함합니다.
            res += count[currentMask].toLong()
            
            // 모든 알파벳에 대해 현재 상태에서 하나의 비트만 변경한 상태를 확인합니다.
            // 이는 정확히 하나의 문자만 홀수 번 등장하는 경우를 찾기 위함입니다.
            for (j in 0..9) {
                res += count[currentMask xor (1 shl j)].toLong()
            }
            
            // 현재 상태의 개수를 하나 증가시킵니다.
            ++count[currentMask]
        }
        // 계산된 결과값을 반환합니다.
        return res
    }
}
