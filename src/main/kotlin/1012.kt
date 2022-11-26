import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val T = br.readLine().toInt()
    repeat(T) {
        val (m, n, k) = br.readLine().split(' ').map { it.toInt() }
        val graph = Array(n) { Array(m) {0} } //세로는 N이고 Y이다. 가로는 M이고 X다.
        val visited = Array(n) { Array(m) { false } }
        var result = 0
        repeat(k) {
            var (y, x) = br.readLine().split(' ').map { it.toInt() }
            graph[x][y] = 1
        }
        fun dfs(x: Int, y: Int){
            if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || graph[x][y] == 0)
                return
            visited[x][y] = true
            dfs(x - 1, y)
            dfs(x, y - 1)
            dfs(x + 1, y)
            dfs(x, y + 1)
            return
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(i,j)
                    result++
                }
            }
        }
        bw.write("$result\n")
    }
    bw.close()
}
