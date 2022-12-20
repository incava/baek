import java.lang.Integer.min
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

data class Nodes(val a:Pair<Int,Int>):Comparable<Nodes>{
    override fun compareTo(other: Nodes): Int = a.second - other.a.second
}

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val times = br.readLine().toInt()
    repeat(times) {
        val (n, m, t) = br.readLine().split(' ').map { it.toInt() } // 교차로, 도로, 목적지
        val (s, g, h) = br.readLine().split(' ').map { it.toInt() } // 출발지, 교차로 1,2
        val graph = Array(n+1) { ArrayList<Pair<Int, Int>>() }
        val inf = Int.MAX_VALUE
        repeat(m) {
            val (a, b, d) = br.readLine().split(' ').map { it.toInt() } // m개만큼 그래프 a->b c는가중치
            graph[a].add(Pair(b, d))
            graph[b].add(Pair(a, d))
        }
        fun dijkstra(start: Int):Array<Int>{
            val que = PriorityQueue<Nodes>()
            que.add(Nodes(Pair(start, 0)))
            val distance = Array(n + 1) { inf }
            Arrays.fill(distance,inf)
            distance[start] = 0
            while (que.isNotEmpty()) {
                val (dist, now) = que.poll().a
                for (i in graph[dist]) {
                    val cost = now + i.second // 나중 비용
                    if (cost < distance[i.first]) { // 거쳐 가는비용 < 저장된 비용
                        distance[i.first] = cost
                        que.add(Nodes(Pair(i.first, cost)))
                    }
                }
            }
            return distance
        }
        //val s

    }
}







//fun main() {
//    val br = System.`in`.bufferedReader()
//    val bw = System.out.bufferedWriter()
//    val times = br.readLine().toInt()
//    repeat(times) {
//        val (n, m, t) = br.readLine().split(' ').map { it.toInt() } // 교차로, 도로, 목적지
//        val (s, g, h) = br.readLine().split(' ').map { it.toInt() } // 출발지, 교차로 1,2
//        val graph = Array(n+1) { ArrayList<Pair<Int, Int>>() }
//        val inf = Int.MAX_VALUE
//        var distance = Array(n + 1) { inf }
//        repeat(m) {
//            val (a, b, d) = br.readLine().split(' ').map { it.toInt() } // m개만큼 그래프 a->b c는가중치
//            graph[a].add(Pair(b, d))
//            graph[b].add(Pair(a, d))
//        }
//        var arr = HashMap<Int, Int>() //후보군 적립
//        var first = HashMap<Int, Int>() //후보군 적립
//        repeat(t) {
//            val temp = br.readLine().toInt()
//            arr[temp] = 0 //후보군 저장
//            first[temp] = 0
//        }
//        fun dijkstra(start: Int) {
//            val que = PriorityQueue<Nodes>()
//            que.add(Nodes(Pair(start, 0)))
//            //distance = Array(n + 1) { inf }
//            Arrays.fill(distance,inf)
//            distance[start] = 0
//            while (que.isNotEmpty()) {
//                val (dist, now) = que.poll().a
//                for (i in graph[dist]) {
//                    val cost = now + i.second // 나중 비용
//                    if (cost < distance[i.first]) { // 거쳐 가는비용 < 저장된 비용
//                        distance[i.first] = cost
//                        que.add(Nodes(Pair(i.first, cost)))
//                    }
//                }
//            }
//        }
//
//        fun check(a: Int, b: Int, c: Int): Int {
//            if (a == inf || b == inf || c == inf)
//                return inf
//            return a + b + c
//        }
//
//        dijkstra(s)// 후보군들 구하기
//        val sTog = distance[g]
//        val sToh = distance[h]
//        for ((key, _) in first) {
//            first[key] = distance[key] // 처음에서 바로 가는 길 저장.
//        }
//
//        dijkstra(g)
//        val gToh = distance[h] //h to g나 g to h나 같음.
//        // 후보군들 저장.
//
//        for ((key, _) in arr) {
//            arr[key] = distance[key]  // 계속 저장. g to key -> value
//        }
//
//        dijkstra(h) //후보군들 저장. distance[key] = h to key
//        for ((key, value) in arr) {
//            val values = min(check(sTog, gToh, distance[key]), check(sToh, gToh, value))
//            //1번은 s - g - h - key / 2번은 s - h -g - key
//            if (values != inf && values == first[key]!!){
//                bw.write("$key ")
//            }
//            //arr[key] = values  // 계속 저장.
//        }
//        bw.write("\n")
//    }
//    bw.close()
//}