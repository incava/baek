import java.util.PriorityQueue
import java.util.Queue

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val iNF = Int.MAX_VALUE
    val (m,e) = br.readLine().split(' ').map{it.toInt()}
    val start = br.readLine().toInt()
    val graph = Array(m+1){ArrayList<Pair<Int,Int>>()} //그래프 모음
    val distance = Array(m+1){iNF}
    repeat(e){
        val (u,v,w) =  br.readLine().split(' ').map{it.toInt()}
        graph[u].add(Pair(v,w))
    }
    fun dijkstra(s:Int){
        val que = PriorityQueue(Comparator<Pair<Int,Int>>{ a, b->
            when{
                a.second != b.second -> if (a.second > b.second) 1 else -1
                else -> 0
            }
        })
        que.offer(Pair(s,0))
        distance[s] = 0
        while(que.isNotEmpty()){
            val (now , dist) = que.poll()
                for (i in graph[now]){
                    val cost = dist + i.second //다음 경로의 비용
                    if (cost < distance[i.first]) { //저장해놓았던 이동거리보다 거쳐가는 거리가 더 짧다면?
                        distance[i.first] = cost //그 코스트를 distance에 저장.
                        que.add(Pair(i.first,cost)) // que에 그 비용거리를 저장.
                    }
                }
        }
    }
    dijkstra(start)
    distance.drop(1).forEach {
        bw.write("${if (it == iNF) "INF"  else it}\n")}
    bw.close()
}