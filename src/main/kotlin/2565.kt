import java.lang.Math.abs
import java.util.*

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var count = 0
    var arr = Array(11) { Array(2) { 0 } } //Array는 1부터 500까지 이루어짐. 0은 생각안하도록함.
    for(i in 0 until n){
    val (idx, num) = br.readLine().split(' ').map { it.toInt() }
        arr[idx][0] = num //arr[idx][0]은 arr의 값 [1]은 dp값
    }
    for (i in 2 ..10){ //500까지 1은 무조건!! 들어감.
        for (j in 1 until i){
            if (arr[i][0]!=0 && arr[j][1]!=1 && arr[j][0]!=0 && arr[i][0] < arr[j][0]){
                //arr값이 0이라면 없는 값,/ dp값이 1이면 그건 무시./만약 현재값이 가리키는 값보다 전게 자기 값보다 큰경우. 무조건 만남.
                if (abs(i - arr[i][0]) <= abs(j - arr[j][0])){ //j값이 차이가 더 클경우
                    arr[j][1] = 1
                }
                else {arr[i][1] = 1}
            }
        }
    }
    println(arr.contentDeepToString())
    print(count)
}