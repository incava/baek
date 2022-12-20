fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val arr2 = br.readLine().split(' ').map { it.toInt() }
    val x = br.readLine().toInt()
    var cnt = 0
    var start = 0
    var end = n-1
    val arr = arr2.sorted()
    while(start<end){
        if (arr[start] + arr[end] == x){
            cnt++
            start++
            end--
        }
        else if (arr[start] + arr[end] > x) // x보다 큰 경우
            end--
        else
            start++
    }
    bw.write("$cnt")
    bw.close()
}