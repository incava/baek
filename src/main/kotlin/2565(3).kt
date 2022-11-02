import java.util.*
import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine()!!.toInt()
    val arr = Array(n){Array(2){0}}
    val dp = Array(n){1}

    for (i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        arr[i][0] = st.nextToken().toInt()
        arr[i][1] = st.nextToken().toInt()
    }

    arr.sortWith { a, b -> a[0] - b[0] }

    for(i in 1 until n) {
        for(j in 0 until i) {
            if (arr[i][1] > arr[j][1]) { //얘는 값의 오름차순
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }
    println(n-dp.maxOrNull()!!)
}