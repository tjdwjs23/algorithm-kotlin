/**
 * 얀에서는 매년 달리기 경주가 열립니다. 해설진들은 선수들이 자기 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부릅니다. 
 * 예를 들어 1등부터 3등까지 "mumu", "soe", "poe" 선수들이 순서대로 달리고 있을 때, 해설진이 "soe"선수를 불렀다면 2등인 "soe" 선수가 1등인 "mumu" 선수를 추월했다는 것입니다. 즉 "soe" 선수가 1등, "mumu" 선수가 2등으로 바뀝니다.
 * 선수들의 이름이 1등부터 현재 등수 순서대로 담긴 문자열 배열 players와 해설진이 부른 이름을 담은 문자열 배열 callings가 매개변수로 주어질 때, 경주가 끝났을 때 선수들의 이름을 1등부터 등수 순서대로 배열에 담아 return 하는 solution 함수를 완성해주세요.
 */

class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        // playerIdxMap이라는 해시맵을 생성합니다. 이 해시맵은 선수 이름과 인덱스를 매핑하는 역할을 합니다.
        val playerIdxMap = hashMapOf<String, Int>()

        // players 배열을 순회하면서 선수 이름과 인덱스를 playerIdxMap에 저장합니다.
        players.forEachIndexed { i, p ->
            playerIdxMap.put(p, i)
        }

        // callings 배열에 있는 호출을 처리합니다.
        for (c in callings) {
            // 호출된 선수의 인덱스를 가져옵니다.
            val idx = playerIdxMap[c]!!

            // 호출된 선수와 그 이전 선수의 위치를 바꿉니다.
            players[idx] = players[idx-1]
            players[idx-1] = c

            // playerIdxMap을 업데이트합니다.
            playerIdxMap.put(c, idx-1)
            playerIdxMap.put(players[idx], idx)
        }

        // 수정된 players 배열을 반환합니다.
        return players
    }
}
