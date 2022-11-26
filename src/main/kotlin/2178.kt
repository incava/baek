import java.awt.Point
import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(n){Array(m){0}}
    val visited = Array(n){Array(m){0}}
    val xx = arrayOf(0, -1, 0, 1)
    val yy = arrayOf(-1, 0, 1, 0)
    repeat(n){i->
        var temp = br.readLine().toList()
        repeat(m){j->
            graph[i][j]=temp[j]-'0'
        }
    }
    fun bfs(x:Int,y:Int):Int{
        val que:Queue<Pair<Int,Int>> = LinkedList()
            que.add(Pair(x,y))
        var cnt = 1
        visited[x][y] = cnt
        while(true){
            var temp = que.element()
            if (temp == Pair(n-1,m-1))
                return visited[n-1][m-1]
            que.poll()
            for(i in 0 until 4){
                var a = temp.first+xx[i]
                var b = temp.second+yy[i]
                if (a >= 0 && b >= 0 && a < n && b < m && visited[a][b]==0 && graph[a][b]==1){
                    que.offer(Pair(a,b))
                    visited[a][b] = visited[temp.first][temp.second]+1
                }
            }
        }
    }
    bw.write("${bfs(0,0)}")
    bw.close()
}