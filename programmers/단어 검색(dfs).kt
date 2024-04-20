/**
 * m x n문자 그리드 board와 문자열이 주어지면 그리드에 존재하는 경우word 반환됩니다 .true word
 *
 * 단어는 순차적으로 인접한 셀의 문자로 구성될 수 있으며, 인접한 셀은 수평 또는 수직으로 이웃합니다. 동일한 문자 셀은 두 번 이상 사용할 수 없습니다.
 *
 * 예시 1:
 * 입력: 보드 = [["A","B","C","E"],["S","F","C","S"],["A","D", "E","E"]], word = "ABCCED"
 *  출력: true
 */

/**
 * m x n문자 그리드 board와 문자열이 주어지면 그리드에 존재하는 경우word 반환됩니다 .true word
 *
 * 단어는 순차적으로 인접한 셀의 문자로 구성될 수 있으며, 인접한 셀은 수평 또는 수직으로 이웃합니다. 동일한 문자 셀은 두 번 이상 사용할 수 없습니다.
 *
 * 예시 1:
 * 입력: 보드 = [["A","B","C","E"],["S","F","C","S"],["A","D", "E","E"]], word = "ABCCED"
 *  출력: true
 */

class Solution {
    // 주어진 보드에서 특정 단어를 찾을 수 있는지 확인하는 함수
    fun exist(board: Array<CharArray>, word: String): Boolean {
        // 각 위치를 방문했는지 여부를 추적하는 배열 초기화
        val visited = Array(board.size) { BooleanArray(board[0].size) }
        // 보드의 모든 위치에서 DFS를 시작하여 단어를 찾을 수 있는지 확인
        return board.indices.any { i ->
            board[0].indices.any { j ->
                dfs(board, i, j, word, 0, visited)
            }
        }
    }

    // DFS를 사용하여 단어를 찾는 재귀 함수 (꼬리 재귀 최적화 사용)
    private tailrec fun dfs(board: Array<CharArray>, i: Int, j: Int, word: String, index: Int, visited: Array<BooleanArray>): Boolean {
        // 단어의 마지막 글자까지 모두 확인했으면 true 반환
        if (index == word.length) return true
        // 현재 위치가 범위를 벗어나거나, 현재 위치의 글자가 단어의 해당 글자와 다르거나, 이미 방문한 경우 false 반환
        if (i !in board.indices || j !in board[0].indices || board[i][j] != word[index] || visited[i][j]) return false

        // 현재 위치를 방문한 것으로 표시
        visited[i][j] = true

        // 상, 하, 좌, 우 방향으로 이동하며 DFS 수행
        val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
        val found = directions.any { (dr, dc) ->
            dfs(board, i + dr, j + dc, word, index + 1, visited)
        }

        // 현재 위치의 방문 표시를 해제 (다른 경로 탐색을 위해)
        visited[i][j] = false

        // 단어를 찾았으면 true, 그렇지 않으면 false 반환
        return found
    }
}

