fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val line = br.readLine().split(' ')
    val k = line[0].toInt()
    val n = line[1].toLong()
    var arr = Array(k){0L}
    var last = 0L
    for (i in 0 until k) {
        arr[i] = br.readLine().toLong()
        last = kotlin.math.max(last,arr[i])
    }
    var first = 1L
    var result = 0L
    var temp:Long
    var num:Long
    while(last>=first){
        temp = (last+first)/2
        num = 0
        for (i in 0 until k){ //찾기
            num += arr[i] / temp
        }
        if (num >= n) {
            result = kotlin.math.max(result,temp)
                first = temp + 1
        }
        else{
            last = temp - 1
        }
    }
    println(result)
}