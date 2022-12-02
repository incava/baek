import java.lang.Integer.min
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val iNF = Int.MAX_VALUE
    val (m,e) = br.readLine().split(' ').map{it.toInt()}
    val graph = Array(m+1){ArrayList<Pair<Int,Int>>()} //그래프 모음
    repeat(e){
        val (u,v,w) =  br.readLine().split(' ').map{it.toInt()}
        graph[u].add(Pair(v,w))
        graph[v].add(Pair(u,w))
    }
    var distance = Array(m+1){iNF}
    val (mid1,mid2) = br.readLine().split(' ').map{it.toInt()}
    fun dijkstra(s:Int){
        distance = Array(m+1){iNF}
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
    dijkstra(1)
    var di1_v1 = distance[mid1]
    var di1_v2 = distance[mid2]
    dijkstra(mid1)
    var div1_v2 = distance[mid2]
    var div1_m = distance[m]
    dijkstra(mid2)
    var div2_m = distance[m]
    fun check(one:Int,two:Int,three:Int):Int{
        if (one == iNF || two ==iNF || three == iNF)
            return iNF
        return one+two+three
    }
    var result1 = check(di1_v1,div1_v2,div2_m)
    var result2 = check(di1_v2,div1_v2,div1_m)
    if(result1 == iNF && result2 == iNF)
        bw.write("-1")
    else
        bw.write("${min(result1,result2)}")
    bw.close()
}