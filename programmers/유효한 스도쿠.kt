/**
* 9 x 9스도쿠 보드가 유효 한지 확인합니다  . 다음 규칙에 따라 채워진 셀만 검증하면 됩니다  .

* 1-9각 행에는 반복 없이 숫자가 포함되어야 합니다  .
* 1-9 각 열에는 반복 없이 숫자가 포함되어야 합니다  .
* 3 x 3그리드의  9개 하위 상자 각각에는  1-9 반복 없이 숫자가 포함되어야 합니다.
*/

class Solution {
    // isValidSudoku 함수는 2차원 Char 배열인 보드를 받아 유효한 스도쿠인지 확인합니다.
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // 각 행에 대한 HashSet 배열을 준비합니다. 각 HashSet은 해당 행의 숫자들을 저장합니다.
        val rows = Array(9) { HashSet<Char>() }
        // 각 열에 대한 HashSet 배열을 준비합니다. 각 HashSet은 해당 열의 숫자들을 저장합니다.
        val cols = Array(9) { HashSet<Char>() }
        // 3x3 박스에 대한 HashSet 배열을 준비합니다. 각 HashSet은 해당 박스의 숫자들을 저장합니다.
        val boxes = Array(9) { HashSet<Char>() }

        // 보드의 모든 위치에 대해 반복합니다.
        for (i in 0 until 9) { // 행을 위한 반복
            for (j in 0 until 9) { // 열을 위한 반복
                val num = board[i][j] // 현재 위치의 숫자를 불러옵니다.
                if (num != '.') { // 빈 칸이 아닌 경우만 처리합니다.
                    // 현재 숫자가 속한 3x3 박스를 계산합니다.
                    val boxIndex = (i / 3) * 3 + j / 3
                    // 현재 숫자가 이미 해당 행, 열, 또는 박스에 존재하는지 확인합니다.
                    if (num in rows[i] || num in cols[j] || num in boxes[boxIndex]) {
                        return false // 중복이 발견되면 false를 반환합니다.
                    }
                    // 중복이 없으면, 현재 숫자를 해당 행, 열, 박스의 HashSet에 추가합니다.
                    rows[i].add(num)
                    cols[j].add(num)
                    boxes[boxIndex].add(num)
                }
            }
        }
        // 모든 검사를 통과하면 보드가 유효한 스도쿠임을 나타내기 위해 true를 반환합니다.
        return true
    }
}
