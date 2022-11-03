import java.lang.Integer.min

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        var arr = br.readLine().split(' ').map { it.toInt() }.toIntArray()
        var dp = Array(n) { IntArray(n) }
        val sum = IntArray(n)
        sum[0] = arr[0]
        for (i in 1 until n) //SUM 메모이제이션을 위한 Array
            sum[i] = sum[i - 1] + arr[i]

        for (j in 1 until n) { //depth
            for (i in j-1 downTo 0) { // 2개의 파일이 하나로 됨에 따른 j-1
                dp[i][j] = Int.MAX_VALUE
                for (k in i until j) {
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k + 1][j])
                }
                dp[i][j] += if (i != 0) sum[j] - sum[i - 1] else sum[j]
            }
        }
        println(dp[0][n-1])
    }
}