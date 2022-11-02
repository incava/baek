import java.util.PriorityQueue
import kotlin.math.abs

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var n = br.readLine().toInt()
    var lambda = {a:Int,b:Int->
        when{
            a<b -> -1
            a>b -> 1
            else -> 0
        }
    }
    var pq = PriorityQueue(Comparator<Pair<Int,Int>>{a,b->
        when{
            a.first !=b.first -> lambda(a.first,b.first)
            else -> lambda(a.second,b.second)
        }
    })
    var num:Int
    var temp:Pair<Int,Int>
    for (i in 0 until n){
        num = br.readLine().toInt()
        if (num == 0) {
            if (pq.isEmpty())
                bw.write("0\n")
            else {
                temp = pq.poll()
                bw.write("${temp.second}\n")
            }
        }
        else pq.add(Pair(abs(num),num))
        }
    bw.close()
}