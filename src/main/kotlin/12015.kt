import java.lang.Integer.min

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(' ').map { it.toInt() }
    var arylist = ArrayList<Int>()
    arylist.add(0)
    fun binary(num:Int):Int{
        var result = arylist.size
        var first = 0
        var last = arylist.size-1
        var mid:Int
        var temp:Int
        while (last >= first) {
            mid = (last + first) / 2
            temp = arylist[mid]
            if (temp>=num) {
                result = mid
                last = mid - 1
            }
            else
                first = mid + 1
        }
        return result
    }

    for(i in 0 until n){
        var getNum = binary(arr[i])
        if (getNum <= arylist.size-1)
        arylist[getNum] = min(arylist[getNum],arr[i])
        else
            arylist.add(arr[i])
    }
    println(arylist.size-1)
}