import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    var que:Deque<Int> = LinkedList()
    for (i in 0 until n){
        val cmd = br.readLine()!!.split(' ')
        when(cmd[0]){
            "push_back" -> que.addLast(cmd[1].toInt())
            "push_front" ->que.addFirst(cmd[1].toInt())
            "pop_front" ->bw.write("${if (que.isEmpty()) -1 else que.pollFirst()}\n")
            "pop_back" ->bw.write("${if (que.isEmpty()) -1 else que.pollLast()}\n")
            "size" -> bw.write("${que.size}\n")
            "empty" -> bw.write("${if (que.isEmpty()) 1 else 0}\n")
            "front" -> bw.write("${if (que.isEmpty()) -1 else {que.peekFirst()}}\n")
            "back" -> bw.write("${if (que.isEmpty()) -1 else {que.peekLast()}}\n")
        }
    }
    bw.close()
}
