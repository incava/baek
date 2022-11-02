import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    val (n,k) = br.readLine().split(' ').map{it.toInt()}
    var arr = Array(n+1){Array(2){0}}
    var dp = Array(n+1){Array(k+1){0} }
    for (i in 1 ..n) {
        val st = StringTokenizer(br.readLine())
        arr[i][0] = st.nextToken().toInt() //무게
        arr[i][1] = st.nextToken().toInt() // 가치
    }

    for (i in 1 .. n){ //아이템
        for (j in 1..k){ //무게
            if (arr[i][0]<=j){
                dp[i][j]=max(dp[i-1][j],arr[i][1]+dp[i-1][j-arr[i][0]])
            }
            else dp[i][j] = dp[i-1][j]
        }
    }
    //println(arr.contentDeepToString())
    //println(dp.contentDeepToString())
    println(dp[n][k])
}