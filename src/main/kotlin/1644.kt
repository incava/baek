import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val ary = ArrayList<Int>()
    val n = br.readLine().toInt()
    var first = 0
    var end = 0
    var sum = 0
    var cnt = 0
    fun check(x:Int):Boolean{
        for (i in 2 until sqrt(x.toDouble()).toInt()+1) {
            if (x%i==0)
                return false
        }
        return true
    }
    for(i in 2 until n+1){
        if (check(i))
            ary.add(i)
    }
    val size = ary.size
    while(first<=end){
        if (sum == n)
            cnt++
        if (sum >= n) {
            sum -= ary[first++]
        }
        else if (size<=end) //sum이 n보다 작을때
            break
        else sum+=ary[end++]
    }
    bw.write("$cnt")
    bw.close()
}