import java.lang.Integer.max
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    var arr = StringTokenizer(br.readLine()).run { IntArray(n) {nextToken().toInt()} }
    var dp = Array(n) { Array(2) { 1 } }
    for(i in 1 until n) {
        for (j in 0 until i) {
            if (arr[i] > arr[j]) {
                dp[i][0] = maxOf(dp[i][0], dp[j][0] + 1)
            }
        }
    }
    for(i in n-1 downTo  0) {
        for (j in i+1 until n) {
            if (arr[i] > arr[j]) {
                dp[i][1] = maxOf(dp[i][1], dp[j][1] + 1)
            }
        }
    }
    var maxNum = 0
    for (i in 0 until n){
        maxNum = max(maxNum,dp[i][0]+dp[i][1])
    }
    print(maxNum-1)
}



