/**
 * 케빈 베이컨의 6단계 법칙에 의하면 지구에 있는 모든 사람들은 최대 6단계 이내에서 서로 아는 사람으로 연결될 수 있다. 케빈 베이컨 게임은 임의의 두 사람이 최소 몇 단계 만에 이어질 수 있는지 계산하는 게임이다.
 * 오늘은 Baekjoon Online Judge의 유저 중에서 케빈 베이컨의 수가 가장 작은 사람을 찾으려고 한다. 케빈 베이컨 수는 모든 사람과 케빈 베이컨 게임을 했을 때, 나오는 단계의 합이다.
 * BOJ 유저의 수와 친구 관계가 입력으로 주어졌을 때, 케빈 베이컨의 수가 가장 작은 사람을 구하는 프로그램을 작성하시오.
 */

fun main() = System.`in`.bufferedReader().run {
    // n: 노드의 개수, m: 간선의 개수
    val (n, m) = readLine().split(" ").map { it.toInt() }
    // 무한대로 초기화된 거리 배열을 생성합니다. 노드는 1부터 시작하므로 n + 1의 크기로 배열을 생성합니다.
    val dist = Array(n + 1) { IntArray(n + 1) { 1_000_000_000 } }

    // m개의 간선에 대한 정보를 입력받아 거리 배열을 갱신합니다.
    repeat(m) {
        val (from, to) = readLine().split(" ").map { it.toInt() }
        dist[from][to] = 1 // from에서 to로 가는 가중치 1입니다.
        dist[to][from] = 1 // to에서 from으로 가는 가중치도 1입니다. (양방향)
    }

    // 플로이드-워셜 알고리즘을 실행하여 모든 노드 쌍 사이의 최단 거리를 계산합니다.
    floydWarshall(dist, n)

    // 최소 합을 가지는 노드를 찾습니다. 만약 동일한 합을 가진 노드가 여러 개라면, minByOrNull은 가장 작은 인덱스를 반환합니다.
    val result = (1..n).minByOrNull { dist[it].sum() } ?: 1
    print(result)
}

fun floydWarshall(dist: Array<IntArray>, n: Int) {
    repeat(n) { k -> // 중간노드
        repeat(n) { i -> // 시작노드
            repeat(n) { j -> // 도착 노드
                // 현재 i에서 j로 가는 최단 거리와 i에서 k를 거쳐 j로 가는 거리를 비교하여 더 작은 값으로 갱신합니다.
                if (dist[i + 1][j + 1] > dist[i + 1][k + 1] + dist[k + 1][j + 1]) {
                    dist[i + 1][j + 1] = dist[i + 1][k + 1] + dist[k + 1][j + 1]
                }
            }
        }
    }
}
