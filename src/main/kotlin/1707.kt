import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val t = br.readLine().toInt()
    repeat(t){
        val (n,m) = br.readLine().split(' ').map { it.toInt() }
        val graph = Array(n+1){ArrayList<Int>()}
        val visited = Array(n+1){0}
        repeat(m){
            val (u,v) = br.readLine().split(' ').map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }
        fun bfs(f:Int):Boolean{
            val que:Queue<Int> = LinkedList()
            que.offer(f)
            visited[f] = 1
            while(que.isNotEmpty()){
                val temp = que.element()
                que.poll()
                for (i in graph[temp]){
                    if (visited[i] == visited[temp]){
                        return false
                    }
                    if (visited[i] == 0){
                        //if (visited[temp] == 1) visited[i] = 2 else visited[i] = 1
                        visited[i] = visited[temp] * -1
                        que.offer(i)
                    }
                }
            }
            return true
        }
        fun check():String{
            for (i in 1 .. n){
                if (visited[i]==0)
                    if (!bfs(i))
                        return "NO"
            }
            return "YES"
        }
        bw.write("${check()}\n")
    }
    bw.close()
}