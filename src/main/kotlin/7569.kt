import java.lang.Integer.max
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (m, n, h) = br.readLine().split(' ').map { it.toInt() }
    val visited = Array(h) {Array(n){IntArray(m)}}
    val result = ArrayList<Triple<Int, Int, Int>>()
    val xx = arrayListOf(0,0,1,-1,0,0)
    val yy = arrayListOf(0,0,0,0,-1,1)
    val zz = arrayListOf(1,-1,0,0,0,0)
    repeat(h) { height ->
        repeat(n) {x->
            val temps = br.readLine().split(' ').map { it.toInt() }
            repeat(m) {
                visited[height][x][it] = temps[it]
            }
        }
    }
    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (visited[i][j][k] == 1)
                    result.add(Triple(i, j, k))
            }
        }
    }

    fun bfs(list: ArrayList<Triple<Int, Int, Int>>) {
        if (list.isEmpty())
            return
        val que: Queue<Triple<Int, Int, Int>> = LinkedList()
        for (firstNum in list)
            que.offer(firstNum)
        while (que.isNotEmpty()) {
            val temp = que.element()
            que.poll()
            for (i in 0 until 6) {
                val new = Triple(temp.first + xx[i], temp.second + yy[i],temp.third + zz[i])
                if (new.first in 0 until h && new.second in 0 until n && new.third in 0 until m && visited[new.first][new.second][new.third] == 0) {
                    visited[new.first][new.second][new.third] = visited[temp.first][temp.second][temp.third] + 1
                    que.offer(new)
                }
            }
        }
    }
    bfs(result)
    fun check(): Int {
        var answer = 0
        for (i in 0 until h) {
            for (j in 0 until n) {
                for (k in 0 until m) {
                    answer = max(answer, visited[i][j][k])
                    if (visited[i][j][k] == 0)
                        return -1
                }
            }
        }
        return answer - 1
    }
    bw.write("${check()}")
    bw.close()
}
