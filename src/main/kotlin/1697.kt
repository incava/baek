import java.util.LinkedList
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (n,k) = br.readLine().split(' ').map { it.toInt() }
    val visited = Array(100001){0}

    fun dfs(v:Int){
        val que : Queue<Int> = LinkedList()
        que.offer(v)
        visited[v] = 0
        while(que.isNotEmpty()){
            val temp = que.element()
            if (temp == k)
                return
            que.poll()
            val arr = ArrayList<Int>()
            arr.add(temp + 1)
            arr.add(temp - 1)
            arr.add(temp * 2)
            for (i in arr){
                if (i in 0..100000 && visited[i] == 0){
                    visited[i] = visited[temp]+1
                    que.offer(i)
                }
            }
        }
    }
    dfs(n)
    bw.write("${visited[k]}")
    bw.close()
}