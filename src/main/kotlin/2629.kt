import kotlin.math.abs

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val nAry = br.readLine().split(' ').map { it.toInt() }
    val comAry = Array(31){0}
    repeat(n){
        comAry[it] = nAry[it]
    }
    val m = br.readLine().toInt()
    val questAry = br.readLine().split(' ').map { it.toInt() }
    val dp = Array(31){Array(15001){false}}
    fun combination(cnt:Int,value:Int){ //dfs로 빠르게.
        if (cnt > n || dp[cnt][value]) return //or문 두개를 바꿔쓰면 index에러뜹니다. 사전에 방지해야함.
        dp[cnt][value] = true
        combination(cnt+1,value) //원래 있던 ary
        combination(cnt+1,value + comAry[cnt]) //자신을 포함하고 sum까지의 ary
        combination(cnt+1,abs(value - comAry[cnt]))  //자신을 빼고 절댓값 -> 자연수이므로.
    }
    combination(0,0)
    for(i in questAry){
        if (i <= 15000 && dp[n][i])
            bw.write("Y ")
        else
            bw.write("N ")
    }
    bw.close()
}