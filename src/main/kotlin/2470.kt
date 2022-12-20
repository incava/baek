import java.lang.Math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr2 = br.readLine().split(' ').map { it.toInt() }
    var start = 0
    var end = n-1
    var result1 = 0
    var result2 = n-1
    val arr = arr2.sorted()
    while(start<end){
        if (abs(arr[result1] + arr[result2]) > abs(arr[start] + arr[end])) { // abs비교해서 저장한것보다 더 작은 경우
            result1 = start
            result2 = end
        }
        if (abs(arr[start])>abs(arr[end]))
            start++
        else
            end--
    }
    bw.write("${arr[result1]} ${arr[result2]}")
    bw.close()
}