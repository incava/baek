import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m,r) =  br.readLine().split(' ').map{it.toInt()}
    var visited = Array(n+1){0}
    val graph = Array(n+1){ArrayList<Int>()}
    repeat(m){
        val (u,v) = br.readLine().split(' ').map{it.toInt()}
        graph[u].add(v)
        graph[v].add(u)
    }
    repeat(n+1){
    graph[it].sort()
    }

    fun bfs(nodeNum:Int){
        var que: Queue<Int> = LinkedList()
        que.offer(nodeNum)
        var cnt = 1
        visited[nodeNum] = cnt
        cnt++
        while (que.isNotEmpty()) {
            var temp = que.element()
            que.poll()
            for (i in graph[temp]) {
                if (visited[i]==0) {
                    visited[i] = cnt
                    cnt++
                    que.offer(i)
                }
            }
        }
    }
    bfs(r)
    for(i in 1..n){
        bw.write("${visited[i]}\n")
    }
    bw.close()
}