import java.lang.Integer.max
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (m, n) = br.readLine().split(' ').map { it.toInt() }
    val visited = Array(n) { IntArray(m) { 0 } }
    val result = ArrayList<Pair<Int, Int>>()
    val xx = arrayListOf(1, 0, -1, 0)
    val yy = arrayListOf(0, 1, 0, -1)
    repeat(n) { x ->
        val array = br.readLine().split(' ').map { it.toInt() }
        repeat(m) {
            visited[x][it] = array[it]
        }
    }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j] == 1)
                result.add(Pair(i, j))
        }
    }

    fun bfs(list: ArrayList<Pair<Int, Int>>) {
        if (list.isEmpty())
            return
        val que: Queue<Pair<Int, Int>> = LinkedList()
        for (firstNum in list)
            que.offer(firstNum)
        while (que.isNotEmpty()) {
            val temp = que.element()
            que.poll()
            for (i in 0 until 4) {
                val new = Pair(temp.first + xx[i], temp.second + yy[i])
                if (new.first in 0 until n && new.second in 0 until m && visited[new.first][new.second] == 0) {
                    visited[new.first][new.second] = visited[temp.first][temp.second] + 1
                    que.offer(new)
                }
            }
        }
    }
    bfs(result)
    fun check(): Int {
        var answer = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                answer = max(answer, visited[i][j])
                if (visited[i][j] == 0)
                    return -1
            }
        }
        return answer - 1
    }
    bw.write("${check()}")
    bw.close()
}
