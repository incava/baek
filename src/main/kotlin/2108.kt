import java.lang.Math.abs
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()
    val n = br.readLine().toInt()
    var array = IntArray(8001) { 0 } //4000개 수 담을 counting
    var count:Float = 0.0F //총갯수
    var result = IntArray(n)
    var array2 = mutableListOf<Int>()
    var many = 0
    for (i in 1..n) { //counting에 담기.
        var a = br.readLine().toInt()
        array[a + 4000] = +1
        count += a
    }
     //가장 많이나타나는 값
    //(count / n).toDouble().roundToInt()
    //for (i in 2 .. n){
    //    array[i] = array[i] + array[i-1]
    //}
   var arrMax = array.max()
    var j = 0
    for (i in 1..8000) {
        if (array[i] != 0) {
            if (array[i] == arrMax) {
                array2.add(i)
            }
            result[j] = i - 4000
            array[i] -= 1
            j++
        }
    }
    if (array2.count() != 1){
        if (array2.count() == 2){
            many = array2[0]
        }
        else {
            many = array2[1]
        }
    }
    println((count / n).roundToInt())
    println(result[(n+1)/2])
    println(many-4000)
    println(abs(result[0] - result[n-1]))
}

