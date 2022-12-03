import java.util.PriorityQueue

data class Node(val a:Pair<Int,Int>):Comparable<Node>{
    override fun compareTo(other: Node): Int = a.second - other.a.second
    }
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val (n,m) = br.readLine().split(' ').map{it.toInt()}
    val inf = Int.MAX_VALUE

    fun dijkstra(start:Int):Int{
        val distance = Array(200001){inf}
        val que = PriorityQueue<Node>()
            que.add(Node(Pair(start,0)))
        distance[start] = 0
        while(que.isNotEmpty()){
            val (dist,now) = que.poll().a //distance와 cost
            if (dist == m)
                return distance[m]
            val Arylist = ArrayList<Pair<Int,Int>>()
            Arylist.add(Pair(dist+1,1))
            Arylist.add(Pair(dist*2,0))
            Arylist.add(Pair(dist-1,1))
            for(i in Arylist){
                val cost = now + i.second //다음 경로의 비용
                if(i.first in 0..100001 && cost<distance[i.first]){
                    distance[i.first] = cost
                    que.add(Node(Pair(i.first,cost)))
                }
            }
        }
        return distance[m]
    }

    bw.write("${dijkstra(n)}")
    bw.close()
}