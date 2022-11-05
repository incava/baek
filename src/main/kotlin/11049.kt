import java.lang.Integer.min

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var arr = Array(n) { IntArray(2) }
    var dp = Array(n) { IntArray(n) }
    repeat(n) { nn ->
        val line = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        arr[nn] = line
    }
    for (j in 1 until n) { //depth
        for (i in j - 1 downTo 0) { // 2개의 파일이 하나로 됨에 따른 j-1
            dp[i][j] = Int.MAX_VALUE
            for (k in i until j) {
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1])
            }
        }
    }
    println(dp[0][n-1])
}