import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt() // 도시 갯수
    val m = br.readLine().toInt() // 버스 갯수
    val inf = 1_000_000_000
    val ary = Array(n){Array(n){inf}}
    repeat(m){
        val (x,y,z) = br.readLine().split(' ').map { it.toInt() }
        ary[x-1][y-1] = min(ary[x-1][y-1],z)
    }
    repeat(n){ //자기자신은 0
        ary[it][it] = 0 //00 11 22 33 44
    }

    fun floyd(){
        for(k in 0 until n){
            for(i in 0 until  n){
                for(j in 0 until  n){
                    ary[i][j] = min(ary[i][j],ary[i][k]+ary[k][j])
                }
            }
        }
    }
    floyd()
    ary.forEach {
        it.forEach { x ->
            if (x == inf)
                bw.write("0 ")
            else
               bw.write("$x ")
        }
        bw.write("\n")
    }
    bw.close()
}