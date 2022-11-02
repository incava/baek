import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var first = br.readLine() //이거자체가 배열
    var second = br.readLine()
    var maxNum = 0
    val n = first.length
    fun findIdx(i:Int,idx:Int):Int{
        var sub = second.substring(idx+1,second.length)
        return sub.indexOf(first[i])
    }
    var dp = Array(n){Array(2){-1}}
    // 0값에는 idx가 들어갈 예정. 1값에는 dp누적합 길이가 들어갈예정.
    var idx = findIdx(0,dp[0][0])
    if (idx!=-1){ //null아닐경우
        dp[0][0] = idx
        maxNum = 1
        dp[0][1] = 1
    }


    for(i in 1 until n){
        dp[i][1] = 1 //초깃값 1
        dp[i][0] = findIdx(i,-1)
        if (dp[i][0]!=-1){ //i는 찾고자 하는 값 , dp[i-1][0]은 시작위치.
            //아예없으면 시작도 하지말라고.
        for ( j in 0 until i) {
            var idx = findIdx(i, dp[j][0]) //만약 j기점으로 있을경우?
            //println(idx)
            if (idx != -1) { //null아닐경우 즉 있긴 하다는 것.
                if (dp[i][1] < dp[j][1]){
                    dp[i][1] = dp[j][1]+1
                    dp[i][0] = dp[j][0]+idx+1
                }
                maxNum = max(maxNum, dp[i][1])
            }
        }
        }
    }
    //println(dp.contentDeepToString())
    print(maxNum)
}
