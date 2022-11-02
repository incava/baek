import java.lang.Integer.max

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var maxNum = 0
    val size = 501
    var arr = Array(size) { Array(2) { 0 } } //Array는 1부터 500까지 이루어짐. 0은 생각안하도록함.
    for(i in 0 until n){
        val (idx, num) = br.readLine().split(' ').map { it.toInt() }
        arr[idx][0] = num //arr[idx][0]은 arr의 값 [1]은 dp값 // arr[idx]= 8
    }
    for (i in 1 until size){ //500까지 1은 무조건!! 들어감.
        arr[i][1] = 1
        if (arr[i][0]!=0) { //0일경우 패스
            for (j in 1 until i) {
                if (arr[i][0] > arr[j][0]) {
                        arr[i][1] = max(arr[i][1],arr[j][1] + 1)
                        maxNum = max(maxNum,arr[i][1])
                    }
                }
            }
        }
    //println(arr.contentDeepToString())
    print(n-maxNum)
    }