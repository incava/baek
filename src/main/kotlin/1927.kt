import java.util.PriorityQueue

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    var n = br.readLine().toInt()
    var pq = PriorityQueue<Int>()
    var num:Int
    for (i in 0 until n){
        num = br.readLine().toInt()
        when(num){
            0 -> bw.write("${if (pq.isEmpty()) 0 else pq.poll()}\n")
            else -> pq.add(num)
        }
    }
    bw.close()
}