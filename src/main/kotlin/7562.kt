import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t){
        val l = br.readLine().toInt()
        val (a,b) = br.readLine().split(' ').map{it.toInt()}
        val (c,d) = br.readLine().split(' ').map{it.toInt()}
        val visited = Array(l){IntArray(l)}
        val kx = arrayListOf(-1,1,2,2,-1,1,-2,-2)
        val ky = arrayListOf(2,2,-1,1,-2,-2,-1,1)
        fun dfs(x:Int,y:Int):Int{
            val que:Queue<Pair<Int,Int>> = LinkedList()
                que.offer(Pair(x,y))
            while(true){
                val temp = que.element()
                if (temp == Pair(c,d))
                    return visited[c][d]
                que.poll()
                for(i in 0 until 8){
                    val now = Pair(temp.first+kx[i],temp.second+ky[i])
                    if (now.first in 0 until l && now.second in 0 until l && visited[now.first][now.second]==0){
                        visited[now.first][now.second] = visited[temp.first][temp.second]+1
                        que.offer(now)
                    }
                }
            }
        }
        bw.write("${dfs(a,b)}\n")
    }
    bw.close()
}