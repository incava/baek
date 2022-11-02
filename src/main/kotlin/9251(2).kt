import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var first = br.readLine() //이거자체가 배열
    var second = br.readLine()
    val n = first.length
    val m = second.length
    var dp = Array(n+1){Array(m+1){0}}
    for (i in 1 .. first.length){
        for (j in 1..  second.length){
            if (first[i-1] == second[j-1]){
                dp[i][j] = dp[i-1][j-1]+1
            }
            else dp[i][j] = max(dp[i][j-1],dp[i-1][j])
        }
    }
    print(dp[n][m])
}
