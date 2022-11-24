import kotlin.collections.ArrayList

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()
    val graph = Array(n){Array(n){0}}
    val visited = Array(n){Array(n){false}}
    val arr = ArrayList<Int>()
    repeat(n){x->
        var temp = br.readLine().toList()
        repeat(n){y->
        graph[x][y]=temp[y]-'0'
        }
    }
    fun dfs(x:Int,y:Int):Int{
        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || graph[x][y]==0)
            return 0
        visited[x][y]=true
        var cnt = 1
        cnt+=dfs(x-1,y)
        cnt+=dfs(x,y-1)
        cnt+=dfs(x+1,y)
        cnt+=dfs(x,y+1)
        return cnt
    }

    for(i in 0 until n){
        for(j in 0 until n){
            if (graph[i][j]==1 && !visited[i][j]){
                arr.add(dfs(i,j))
            }
        }
    }

    bw.write("${arr.size}\n")
    arr.sort()
    for (i in arr)
        bw.write("$i\n")
    bw.close()
}
