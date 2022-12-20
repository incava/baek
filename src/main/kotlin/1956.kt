import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n,m) =  br.readLine().split(' ').map { it.toInt() } // 마을,도로 갯수
    val inf = 1_000_000_000
    val ary = Array(n+1){Array(n+1){inf}}
    repeat(m){
        val (x,y,z) = br.readLine().split(' ').map { it.toInt() }
        ary[x][y] = z
    }
    repeat(n){ //자기자신은 0
        ary[it][it] = 0 //00 11 22 33 44
    }

    fun floyd(){
        for(k in 1 until n+1){
            for(i in 1 until  n+1){
                for(j in 1 until  n+1){
                    ary[i][j] = min(ary[i][j],ary[i][k]+ary[k][j])
                }
            }
        }
    }
    floyd()
    var result = ary[1][2] + ary[2][1]
    for(i in 1 until n+1){
        for( j in 1 until  n+1){
            if(j!=i)
            result = min(result,ary[i][j]+ary[j][i])
        }
    }
    bw.write(if (result<inf) "$result" else "-1")
    bw.close()
}