import java.lang.Integer.min

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    var first = 1
    var last = k // n^2 가 아닌 k인 이유는 k는 min(10^9,N^2보다 작거나 같은 자연수기 때문.)
    // 즉 k가 마지막을 의미.
    var mid:Int
    var result = 0
    fun numcheck(mid:Int):Int {
        var num = 0
        for (i in 1 ..n){
            num+=min(mid/i,n)
        }
        return num
    }
    while(last>=first){
        mid = (first+last)/2
        if (numcheck(mid)>=k){
            result = mid
            last = mid - 1
        }
        else
            first = mid + 1
    }
    println(result)
}