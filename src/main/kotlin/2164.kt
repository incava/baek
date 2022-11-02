import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var que:Queue<Int> = LinkedList()
    for(i in 1 .. n){
        que.add(i)
    }
    while (que.size != 1) {
            que.remove()
            que.add(que.remove())
        }
        println(que.element())
    }