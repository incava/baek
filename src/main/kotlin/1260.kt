import java.util.LinkedList
import java.util.Queue
import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m,r) = br.readLine().split(" ").map{it.toInt()}
    var graph = Array(n+1){ArrayList<Int>()}
    var visited = Array(n+1){false}
    repeat(m){
        val (u,v) = br.readLine().split(" ").map{it.toInt()}
        graph[u].add(v)
        graph[v].add(u)
    }
    fun dfs(node:Int){
        var stk = Stack<Int>()
        stk.push(node)
        while (stk.isNotEmpty()){
            val temp = stk.pop()
            if (visited[temp]) continue
            visited[temp] = true
            bw.write("$temp ")
            for (i in graph[temp]){
                if (!visited[i]){
                    stk.push(i)
                }
            }
        }
    }
    fun bfs(node:Int){
        var que:Queue<Int> = LinkedList()
            que.offer(node)
        while (que.isNotEmpty()){
            val temp = que.element()
                que.poll()
            if (visited[temp]) continue
            visited[temp] = true
            bw.write("$temp ")
            for (i in graph[temp]){
                if (!visited[i]){
                    que.offer(i)
                }
            }
        }
    }
    for(i in graph){
        i.sortDescending()
    }
    dfs(r)
    bw.write("\n")
    visited = Array(n+1){false}
    for(i in graph){
        i.sort()
    }
    bfs(r)
    bw.close()
}