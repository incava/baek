import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    var queue:Queue<Int> = LinkedList()

    for (i in 0 until n) {
        val (k, idx) = br.readLine().split(' ').map { it.toInt() }
        var arr = br.readLine().split(' ').map { it.toInt() }.toMutableList()
        var tempN: Int = arr[idx]
        var sortArr = arr.sorted().reversed()
    }
}