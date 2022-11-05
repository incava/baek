fun main() {
    val br = System.`in`.bufferedReader()
    val (m,n) = br.readLine().split(' ').map{it.toInt()}
    val arr = Array(m){IntArray(n)}
    val dp = Array(m){IntArray(n){-1} }
    repeat(m){i->
        arr[i]=br.readLine().split(' ').map{it.toInt()}.toIntArray()
    }
fun dfs(i:Int,j:Int):Int{
        if (i == m-1 && j == n-1)
            return 1
        if (dp[i][j]==-1) { //-1은 지나가지 않은 곳
            dp[i][j]=0 // 0이라면 최소 지나는 갔다.
            if (i > 0 && arr[i - 1][j] < arr[i][j]) { //상하좌우에서 최대한 갈 수 있을때 까지 가기.
                dp[i][j] += dfs(i - 1, j)
            }
            if (i < m - 1 && arr[i + 1][j] < arr[i][j]) {
                dp[i][j] += dfs(i + 1, j)
            }
            if (j > 0 && arr[i][j - 1] < arr[i][j]) {
                dp[i][j] += dfs(i, j - 1)
            }
            if (j < n - 1 && arr[i][j + 1] < arr[i][j]) {
                dp[i][j] += dfs(i, j + 1)
            }
        }
    return dp[i][j]
}
    dfs(0,0)
    println(dp[0][0])
}