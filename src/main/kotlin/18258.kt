import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    var que = LinkedList<Int>()
    for (i in 0 until n){
        val cmd = br.readLine()!!.split(' ')
        when(cmd[0]){
            "pop" -> bw.write("${if (que.isEmpty()) -1 else que.poll()}\n") //if (que.isEmpty()) bw.write("-1") else bw.write("${que.poll()}")
            "size" -> bw.write("${que.size}\n")
            "empty" -> bw.write("${if (que.isEmpty()) 1 else 0}\n") //if (que.isEmpty()) bw.write("1") else bw.write("0")
            "front" -> bw.write("${if (que.isEmpty()) -1 else {que.element()}}\n")
                         //if (que.isEmpty()) bw.write("-1") else bw.write("${que.element()}\n")
            "back" -> bw.write("${if (que.isEmpty()) -1 else {que.last()}}\n") //if (que.isEmpty()) bw.write("-1") else bw.write("${que.peek()}\n")
            else -> que.add(cmd[1].toInt())
        }
    }
    bw.close()
}

