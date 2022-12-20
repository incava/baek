import java.lang.Integer.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,s) = br.readLine().split(' ').map { it.toInt() }
    val arr = br.readLine().split(' ').map { it.toInt() }
    var start = 0
    var end = 0
    var sum = 0
    var result = n+1
    while (start <= end) {
        if(sum >= s) { // s가 sum보다 클 때
            result = min(result,end-start)
            sum-=arr[start++]
        }
        else if (end == n) break
        else{
            sum+=arr[end++]
        }
    }
    bw.write(if (result==n+1) "0" else "$result")
    bw.close()
}
