import java.lang.Integer.max

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val lineTemp = br.readLine().split(' ')
    val N = lineTemp[0].toInt()
    val M = lineTemp[1].toLong()
    val line= br.readLine().split(' ')
    var arr = Array<Long>(N){0}
    var maxNum = 0L
    for (i in 0 until N){
        arr[i] = line[i].toLong()
        maxNum = kotlin.math.max(maxNum,arr[i])
    }
    var first = 0L
    var last = maxNum
    var temp:Long
    var mid:Long
    var result = 0L
    while(last>=first){
        mid = (last+first) / 2 //절단
        temp= 0L
        for (i in 0 until N){
            if (mid<arr[i]) temp += (arr[i] - mid)
        }
        if (temp >= M) {
            result = kotlin.math.max(result, mid)
            first = mid + 1
        }
        else
            last = mid - 1
    }
    println(result)
}