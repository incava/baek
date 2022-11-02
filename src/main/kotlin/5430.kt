import java.util.Deque
import java.util.LinkedList

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()

    for (i in 0 until n) {
        var cmd = br.readLine()
        var num = br.readLine().toInt()
        var arrayTemp = br.readLine()
        //var number = arrayTemp.substring(1, arrayTemp.length-1);
        var number = arrayTemp.replace("[","").replace("]","")
        var deque: Deque<Int> = LinkedList()
        if(number!="") deque.addAll(number.split(",").map { it.toInt() })
        var r = 1
        var flag = false

        for (element in cmd) {
            when (element) {
                'R' -> r *= -1
                'D' -> if (deque.isEmpty()) {
                    flag = true
                    bw.write("error\n")
                    break
                } else {if (r == 1) deque.pollFirst() else deque.pollLast()}
            }
        }
        if (flag) continue
        bw.write("[${ if(r==1) deque.joinToString(",") else deque.reversed().joinToString(",")}]\n")
    }
    bw.close()
}