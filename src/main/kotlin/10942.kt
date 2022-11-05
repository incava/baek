import java.lang.Integer.min
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }
    var dp = Array(n){IntArray(n){1} } //1로 초기화
    val m = br.readLine().toInt()
    for(i in 0 until n){
        for(j in 0 until i+1){ //짝수이면
            if (i == j) dp[i][j] = 1
            else {
                dp[j][i] = min(dp[j+1][i-1],if (arr[i]==arr[j]) 1 else 0)
            }
            }
        }
    repeat(m){
        val (s,e) = br.readLine().split(' ').map {it.toInt()}
        bw.write("${dp[s-1][e-1]}\n")
    }
    bw.close()
}